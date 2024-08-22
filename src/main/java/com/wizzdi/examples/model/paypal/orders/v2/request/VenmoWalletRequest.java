package com.wizzdi.examples.model.paypal.orders.v2.request;

public class VenmoWalletRequest {

  private String vault_id;

  private String email_address;

  private VenmoWalletExperienceContext experience_context;

  private VenmoWalletAttributes attributes;

  /**
   * @return vault_id
   */
  public String getVault_id() {
    return this.vault_id;
  }

  /**
   * @param vault_id vault_id to set
   * @return VenmoWalletRequest
   */
  public <T extends VenmoWalletRequest> T setVault_id(String vault_id) {
    this.vault_id = vault_id;
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
   * @return VenmoWalletRequest
   */
  public <T extends VenmoWalletRequest> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return experience_context
   */
  public VenmoWalletExperienceContext getExperience_context() {
    return this.experience_context;
  }

  /**
   * @param experience_context experience_context to set
   * @return VenmoWalletRequest
   */
  public <T extends VenmoWalletRequest> T setExperience_context(
      VenmoWalletExperienceContext experience_context) {
    this.experience_context = experience_context;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public VenmoWalletAttributes getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return VenmoWalletRequest
   */
  public <T extends VenmoWalletRequest> T setAttributes(VenmoWalletAttributes attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
