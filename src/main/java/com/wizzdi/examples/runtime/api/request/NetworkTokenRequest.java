package com.wizzdi.examples.runtime.api.request;

public class NetworkTokenRequest {

  private String number;

  private String expiry;

  private String cryptogram;

  private EciFlag eci_flag;

  private String token_requestor_id;

  /**
   * @return number
   */
  public String getNumber() {
    return this.number;
  }

  /**
   * @param number number to set
   * @return NetworkTokenRequest
   */
  public <T extends NetworkTokenRequest> T setNumber(String number) {
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
   * @return NetworkTokenRequest
   */
  public <T extends NetworkTokenRequest> T setExpiry(String expiry) {
    this.expiry = expiry;
    return (T) this;
  }

  /**
   * @return cryptogram
   */
  public String getCryptogram() {
    return this.cryptogram;
  }

  /**
   * @param cryptogram cryptogram to set
   * @return NetworkTokenRequest
   */
  public <T extends NetworkTokenRequest> T setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return (T) this;
  }

  /**
   * @return eci_flag
   */
  public EciFlag getEci_flag() {
    return this.eci_flag;
  }

  /**
   * @param eci_flag eci_flag to set
   * @return NetworkTokenRequest
   */
  public <T extends NetworkTokenRequest> T setEci_flag(EciFlag eci_flag) {
    this.eci_flag = eci_flag;
    return (T) this;
  }

  /**
   * @return token_requestor_id
   */
  public String getToken_requestor_id() {
    return this.token_requestor_id;
  }

  /**
   * @param token_requestor_id token_requestor_id to set
   * @return NetworkTokenRequest
   */
  public <T extends NetworkTokenRequest> T setToken_requestor_id(String token_requestor_id) {
    this.token_requestor_id = token_requestor_id;
    return (T) this;
  }
}
