package com.wizzdi.examples.model.paypal.orders.v2.response;

public class AuthenticationResponse {

  private LiabilityShift liability_shift;

  private ThreeDSecureAuthenticationResponse three_d_secure;

  private Object authentication_flow;

  private Object exemption_details;

  /**
   * @return liability_shift
   */
  public LiabilityShift getLiability_shift() {
    return this.liability_shift;
  }

  /**
   * @param liability_shift liability_shift to set
   * @return AuthenticationResponse
   */
  public <T extends AuthenticationResponse> T setLiability_shift(LiabilityShift liability_shift) {
    this.liability_shift = liability_shift;
    return (T) this;
  }

  /**
   * @return three_d_secure
   */
  public ThreeDSecureAuthenticationResponse getThree_d_secure() {
    return this.three_d_secure;
  }

  /**
   * @param three_d_secure three_d_secure to set
   * @return AuthenticationResponse
   */
  public <T extends AuthenticationResponse> T setThree_d_secure(
      ThreeDSecureAuthenticationResponse three_d_secure) {
    this.three_d_secure = three_d_secure;
    return (T) this;
  }

  /**
   * @return authentication_flow
   */
  public Object getAuthentication_flow() {
    return this.authentication_flow;
  }

  /**
   * @param authentication_flow authentication_flow to set
   * @return AuthenticationResponse
   */
  public <T extends AuthenticationResponse> T setAuthentication_flow(Object authentication_flow) {
    this.authentication_flow = authentication_flow;
    return (T) this;
  }

  /**
   * @return exemption_details
   */
  public Object getExemption_details() {
    return this.exemption_details;
  }

  /**
   * @param exemption_details exemption_details to set
   * @return AuthenticationResponse
   */
  public <T extends AuthenticationResponse> T setExemption_details(Object exemption_details) {
    this.exemption_details = exemption_details;
    return (T) this;
  }
}
