package com.wizzdi.examples.runtime.api.request;

public class BlikSeamless {

  private String auth_code;

  /**
   * @return auth_code
   */
  public String getAuth_code() {
    return this.auth_code;
  }

  /**
   * @param auth_code auth_code to set
   * @return BlikSeamless
   */
  public <T extends BlikSeamless> T setAuth_code(String auth_code) {
    this.auth_code = auth_code;
    return (T) this;
  }
}
