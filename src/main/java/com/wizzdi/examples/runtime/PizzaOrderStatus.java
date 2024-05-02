package com.wizzdi.examples.runtime;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PizzaOrderStatus extends TextWebSocketHandler {

  private static final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .registerModule(new JavaTimeModule());
  private static final Logger logger = LoggerFactory.getLogger(PizzaOrderStatus.class);
  private static final String PING = "ping";
  private static final String PONG = "pong";
  private static final TextMessage PING_MESSAGE = new TextMessage("{\"type\":\"" + PING + "\"}");
  private static final TextMessage PONG_MESSAGE = new TextMessage("{\"type\":\"" + PONG + "\"}");

  @Autowired private ApplicationEventPublisher eventPublisher;

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    JsonNode jsonNode = objectMapper.readTree(payload);
    if (jsonNode.has("type") && jsonNode.get("type").isTextual()) {
      String type = jsonNode.get("type").asText();
      if (type != null) {
        switch (type) {
          case PING:
            session.sendMessage(PONG_MESSAGE);
            return;
          case PONG:
            return;
        }
      }
    }

    eventPublisher.publishEvent(
        new Message(session, objectMapper.convertValue(jsonNode, PizzaOrderMessage.class)));
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    if (session.getUri() == null) {
      return;
    }
    UriComponents uriComponents =
        UriComponentsBuilder.fromUriString(session.getUri().toString()).build();
    Map<String, String> queryParameters = uriComponents.getQueryParams().toSingleValueMap();

    session.getAttributes().put("pizzaOrderId", uriComponents.getPathSegments().get(2));

    HttpHeaders handshakeHeaders = session.getHandshakeHeaders();

    sessions.put(session.getId(), session);
    super.afterConnectionEstablished(session);
    eventPublisher.publishEvent(new Open(session));
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    sessions.remove(session.getId());
    eventPublisher.publishEvent(new Close(session, status));
    super.afterConnectionClosed(session, status);
  }

  public static List<WebSocketSession> getSessions() {
    return sessions.values().stream().filter(f -> f.isOpen()).collect(Collectors.toList());
  }

  public static final class Message {
    private final WebSocketSession webSocketSession;
    private final PizzaOrderMessage pizzaOrderMessage;

    public Message(WebSocketSession webSocketSession, PizzaOrderMessage pizzaOrderMessage) {
      this.webSocketSession = webSocketSession;
      this.pizzaOrderMessage = pizzaOrderMessage;
    }

    public WebSocketSession webSocketSession() {
      return webSocketSession;
    }

    public PizzaOrderMessage pizzaOrderMessage() {
      return pizzaOrderMessage;
    }
  }

  public static final class Open {
    private final WebSocketSession webSocketSession;

    public Open(WebSocketSession webSocketSession) {
      this.webSocketSession = webSocketSession;
    }

    public WebSocketSession webSocketSession() {
      return webSocketSession;
    }
  }

  public static final class Close {
    private final WebSocketSession webSocketSession;
    private final CloseStatus closeStatus;

    public Close(WebSocketSession webSocketSession, CloseStatus closeStatus) {
      this.webSocketSession = webSocketSession;
      this.closeStatus = closeStatus;
    }

    public WebSocketSession webSocketSession() {
      return webSocketSession;
    }

    public CloseStatus closeStatus() {
      return closeStatus;
    }
  }

  @Scheduled(fixedDelayString = "${websocket.pizzaOrderStatus.ping.interval:30000}")
  public void pingSessions() {
    for (WebSocketSession session : sessions.values()) {
      try {
        session.sendMessage(PING_MESSAGE);
      } catch (Exception e) {
        logger.debug("failed pinging session", e);
      }
    }
  }
}
