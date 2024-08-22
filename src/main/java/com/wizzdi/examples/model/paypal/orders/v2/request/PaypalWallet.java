package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PaypalWallet {

  private String vault_id;

  private String email_address;

  private Name2 name;

  private PhoneWithType phone;

  private String birth_date;

  private TaxInfo tax_info;

  private AddressPortable2 address;

  private PaypalWalletAttributes attributes;

  private PaypalWalletExperienceContext experience_context;

  private String billing_agreement_id;

  /**
   * @return vault_id
   */
  public String getVault_id() {
    return this.vault_id;
  }

  /**
   * @param vault_id vault_id to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setVault_id(String vault_id) {
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
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return name
   */
  public Name2 getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setName(Name2 name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return phone
   */
  public PhoneWithType getPhone() {
    return this.phone;
  }

  /**
   * @param phone phone to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setPhone(PhoneWithType phone) {
    this.phone = phone;
    return (T) this;
  }

  /**
   * @return birth_date
   */
  public String getBirth_date() {
    return this.birth_date;
  }

  /**
   * @param birth_date birth_date to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    return (T) this;
  }

  /**
   * @return tax_info
   */
  public TaxInfo getTax_info() {
    return this.tax_info;
  }

  /**
   * @param tax_info tax_info to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setTax_info(TaxInfo tax_info) {
    this.tax_info = tax_info;
    return (T) this;
  }

  /**
   * @return address
   */
  public AddressPortable2 getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setAddress(AddressPortable2 address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public PaypalWalletAttributes getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setAttributes(PaypalWalletAttributes attributes) {
    this.attributes = attributes;
    return (T) this;
  }

  /**
   * @return experience_context
   */
  public PaypalWalletExperienceContext getExperience_context() {
    return this.experience_context;
  }

  /**
   * @param experience_context experience_context to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setExperience_context(
      PaypalWalletExperienceContext experience_context) {
    this.experience_context = experience_context;
    return (T) this;
  }

  /**
   * @return billing_agreement_id
   */
  public String getBilling_agreement_id() {
    return this.billing_agreement_id;
  }

  /**
   * @param billing_agreement_id billing_agreement_id to set
   * @return PaypalWallet
   */
  public <T extends PaypalWallet> T setBilling_agreement_id(String billing_agreement_id) {
    this.billing_agreement_id = billing_agreement_id;
    return (T) this;
  }
}
