package com.wizzdi.examples.runtime.api.request;

public class Token {

  private String id;

  private TokenType type;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Token
   */
  public <T extends Token> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return type
   */
  public TokenType getType() {
    return this.type;
  }

  /**
   * @param type type to set
   * @return Token
   */
  public <T extends Token> T setType(TokenType type) {
    this.type = type;
    return (T) this;
  }
}
