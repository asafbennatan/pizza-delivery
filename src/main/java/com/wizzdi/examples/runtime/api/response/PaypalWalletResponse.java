package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.AddressPortable2;
import com.wizzdi.examples.runtime.api.request.Name2;
import com.wizzdi.examples.runtime.api.request.TaxInfo;

public class PaypalWalletResponse {

  private String email_address;

  private String account_id;

  private PaypalWalletResponseAccountStatus account_status;

  private Name2 name;

  private PhoneType2 phone_type;

  private Phone2 phone_number;

  private String birth_date;

  private TaxInfo tax_info;

  private AddressPortable2 address;

  private PaypalWalletAttributesResponse attributes;

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return account_id
   */
  public String getAccount_id() {
    return this.account_id;
  }

  /**
   * @param account_id account_id to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setAccount_id(String account_id) {
    this.account_id = account_id;
    return (T) this;
  }

  /**
   * @return account_status
   */
  public PaypalWalletResponseAccountStatus getAccount_status() {
    return this.account_status;
  }

  /**
   * @param account_status account_status to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setAccount_status(
      PaypalWalletResponseAccountStatus account_status) {
    this.account_status = account_status;
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
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setName(Name2 name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return phone_type
   */
  public PhoneType2 getPhone_type() {
    return this.phone_type;
  }

  /**
   * @param phone_type phone_type to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setPhone_type(PhoneType2 phone_type) {
    this.phone_type = phone_type;
    return (T) this;
  }

  /**
   * @return phone_number
   */
  public Phone2 getPhone_number() {
    return this.phone_number;
  }

  /**
   * @param phone_number phone_number to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setPhone_number(Phone2 phone_number) {
    this.phone_number = phone_number;
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
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setBirth_date(String birth_date) {
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
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setTax_info(TaxInfo tax_info) {
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
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setAddress(AddressPortable2 address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public PaypalWalletAttributesResponse getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return PaypalWalletResponse
   */
  public <T extends PaypalWalletResponse> T setAttributes(
      PaypalWalletAttributesResponse attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
