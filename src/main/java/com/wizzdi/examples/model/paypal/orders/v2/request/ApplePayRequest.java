package com.wizzdi.examples.model.paypal.orders.v2.request;

public class ApplePayRequest {

  private String id;

  private String name;

  private String email_address;

  private Phone phone_number;

  private ApplePayDecryptedTokenData decrypted_token;

  private CardStoredCredential stored_credential;

  private String vault_id;

  private Object attributes;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setId(String id) {
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
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return phone_number
   */
  public Phone getPhone_number() {
    return this.phone_number;
  }

  /**
   * @param phone_number phone_number to set
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setPhone_number(Phone phone_number) {
    this.phone_number = phone_number;
    return (T) this;
  }

  /**
   * @return decrypted_token
   */
  public ApplePayDecryptedTokenData getDecrypted_token() {
    return this.decrypted_token;
  }

  /**
   * @param decrypted_token decrypted_token to set
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setDecrypted_token(
      ApplePayDecryptedTokenData decrypted_token) {
    this.decrypted_token = decrypted_token;
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
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setStored_credential(
      CardStoredCredential stored_credential) {
    this.stored_credential = stored_credential;
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
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setVault_id(String vault_id) {
    this.vault_id = vault_id;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public Object getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return ApplePayRequest
   */
  public <T extends ApplePayRequest> T setAttributes(Object attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
