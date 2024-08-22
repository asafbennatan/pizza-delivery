package com.wizzdi.examples.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.security.UserSecurityContext;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class UpdatePizzaOrderFlow {

  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
          .registerModule(new JavaTimeModule());

  @EventListener(condition = "#event.creationDate.isBefore(#event.updateDate)")
  public void runEvent(PizzaOrder event) {
    run(event, null);
  }

  public PizzaOrder run(PizzaOrder pizzaOrder, UserSecurityContext securityContext) {

    List<WebSocketSession> sessions =
        com.wizzdi.examples.model.PizzaOrderStatus.getSessions().stream()
            .filter(f -> pizzaOrder.getId().equals(f.getAttributes().get("pizzaOrderId")))
            .collect(Collectors.toList());

    PizzaOrderMessage pizzaOrderMessage =
        new PizzaOrderMessage()
            .setLon(pizzaOrder.getLon())
            .setLat(pizzaOrder.getLat())
            .setStatus(pizzaOrder.getOrderStatus())
            .setOrderId(pizzaOrder.getId());

    for (WebSocketSession session : sessions) {

      try {
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(pizzaOrderMessage)));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    return pizzaOrder;
  }
}
