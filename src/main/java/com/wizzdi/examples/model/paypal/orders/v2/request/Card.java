package com.wizzdi.examples.model.paypal.orders.v2.request;

public class Card {

  private String id;

  private String name;

  private String number;

  private String expiry;

  private String security_code;

  private String last_digits;

  private CardBrand card_type;

  private CardType type;

  private CardBrand brand;

  private AddressPortable billing_address;

  private CardAttributes attributes;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Card
   */
  public <T extends Card> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Card
   */
  public <T extends Card> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return number
   */
  public String getNumber() {
    return this.number;
  }

  /**
   * @param number number to set
   * @return Card
   */
  public <T extends Card> T setNumber(String number) {
    this.number = number;
    return (T) this;
  }

  /**
   * @return expiry
   */
  public String getExpiry() {
    return this.expiry;
  }

  /**
   * @param expiry expiry to set
   * @return Card
   */
  public <T extends Card> T setExpiry(String expiry) {
    this.expiry = expiry;
    return (T) this;
  }

  /**
   * @return security_code
   */
  public String getSecurity_code() {
    return this.security_code;
  }

  /**
   * @param security_code security_code to set
   * @return Card
   */
  public <T extends Card> T setSecurity_code(String security_code) {
    this.security_code = security_code;
    return (T) this;
  }

  /**
   * @return last_digits
   */
  public String getLast_digits() {
    return this.last_digits;
  }

  /**
   * @param last_digits last_digits to set
   * @return Card
   */
  public <T extends Card> T setLast_digits(String last_digits) {
    this.last_digits = last_digits;
    return (T) this;
  }

  /**
   * @return card_type
   */
  public CardBrand getCard_type() {
    return this.card_type;
  }

  /**
   * @param card_type card_type to set
   * @return Card
   */
  public <T extends Card> T setCard_type(CardBrand card_type) {
    this.card_type = card_type;
    return (T) this;
  }

  /**
   * @return type
   */
  public CardType getType() {
    return this.type;
  }

  /**
   * @param type type to set
   * @return Card
   */
  public <T extends Card> T setType(CardType type) {
    this.type = type;
    return (T) this;
  }

  /**
   * @return brand
   */
  public CardBrand getBrand() {
    return this.brand;
  }

  /**
   * @param brand brand to set
   * @return Card
   */
  public <T extends Card> T setBrand(CardBrand brand) {
    this.brand = brand;
    return (T) this;
  }

  /**
   * @return billing_address
   */
  public AddressPortable getBilling_address() {
    return this.billing_address;
  }

  /**
   * @param billing_address billing_address to set
   * @return Card
   */
  public <T extends Card> T setBilling_address(AddressPortable billing_address) {
    this.billing_address = billing_address;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public CardAttributes getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return Card
   */
  public <T extends Card> T setAttributes(CardAttributes attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
