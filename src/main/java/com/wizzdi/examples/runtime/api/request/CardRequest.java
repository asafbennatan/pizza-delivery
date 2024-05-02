package com.wizzdi.examples.runtime.api.request;

public class CardRequest {

  private CardExperienceContext experience_context;

  private AddressPortable billing_address;

  private CardBrand card_type;

  private CardType type;

  private String last_digits;

  private NetworkTokenRequest network_token;

  private String number;

  private String security_code;

  private CardStoredCredential stored_credential;

  private String name;

  private CardAttributes attributes;

  private String id;

  private String expiry;

  private CardBrand brand;

  private String vault_id;

  /**
   * @return experience_context
   */
  public CardExperienceContext getExperience_context() {
    return this.experience_context;
  }

  /**
   * @param experience_context experience_context to set
   * @return CardRequest
   */
  public <T extends CardRequest> T setExperience_context(CardExperienceContext experience_context) {
    this.experience_context = experience_context;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setBilling_address(AddressPortable billing_address) {
    this.billing_address = billing_address;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setCard_type(CardBrand card_type) {
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setType(CardType type) {
    this.type = type;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setLast_digits(String last_digits) {
    this.last_digits = last_digits;
    return (T) this;
  }

  /**
   * @return network_token
   */
  public NetworkTokenRequest getNetwork_token() {
    return this.network_token;
  }

  /**
   * @param network_token network_token to set
   * @return CardRequest
   */
  public <T extends CardRequest> T setNetwork_token(NetworkTokenRequest network_token) {
    this.network_token = network_token;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setNumber(String number) {
    this.number = number;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setSecurity_code(String security_code) {
    this.security_code = security_code;
    return (T) this;
  }

  /**
   * @return stored_credential
   */
  public CardStoredCredential getStored_credential() {
    return this.stored_credential;
  }

  /**
   * @param stored_credential stored_credential to set
   * @return CardRequest
   */
  public <T extends CardRequest> T setStored_credential(CardStoredCredential stored_credential) {
    this.stored_credential = stored_credential;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setName(String name) {
    this.name = name;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setAttributes(CardAttributes attributes) {
    this.attributes = attributes;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return CardRequest
   */
  public <T extends CardRequest> T setId(String id) {
    this.id = id;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setExpiry(String expiry) {
    this.expiry = expiry;
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
   * @return CardRequest
   */
  public <T extends CardRequest> T setBrand(CardBrand brand) {
    this.brand = brand;
    return (T) this;
  }

  /**
   * @return vault_id
   */
  public String getVault_id() {
    return this.vault_id;
  }

  /**
   * @param vault_id vault_id to set
   * @return CardRequest
   */
  public <T extends CardRequest> T setVault_id(String vault_id) {
    this.vault_id = vault_id;
    return (T) this;
  }
}
