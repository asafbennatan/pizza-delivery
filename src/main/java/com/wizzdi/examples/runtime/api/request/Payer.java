package com.wizzdi.examples.runtime.api.request;

public class Payer {

  private AddressPortable address;

  private String email_address;

  private TaxInfo tax_info;

  private PhoneWithType phone;

  private String birth_date;

  private Name name;

  private String payer_id;

  /**
   * @return address
   */
  public AddressPortable getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return Payer
   */
  public <T extends Payer> T setAddress(AddressPortable address) {
    this.address = address;
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
   * @return Payer
   */
  public <T extends Payer> T setEmail_address(String email_address) {
    this.email_address = email_address;
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
   * @return Payer
   */
  public <T extends Payer> T setTax_info(TaxInfo tax_info) {
    this.tax_info = tax_info;
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
   * @return Payer
   */
  public <T extends Payer> T setPhone(PhoneWithType phone) {
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
   * @return Payer
   */
  public <T extends Payer> T setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    return (T) this;
  }

  /**
   * @return name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Payer
   */
  public <T extends Payer> T setName(Name name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return payer_id
   */
  public String getPayer_id() {
    return this.payer_id;
  }

  /**
   * @param payer_id payer_id to set
   * @return Payer
   */
  public <T extends Payer> T setPayer_id(String payer_id) {
    this.payer_id = payer_id;
    return (T) this;
  }
}
