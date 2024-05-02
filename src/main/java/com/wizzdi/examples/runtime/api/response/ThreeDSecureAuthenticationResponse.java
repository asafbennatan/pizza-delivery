package com.wizzdi.examples.runtime.api.response;

public class ThreeDSecureAuthenticationResponse {

  private ParesStatus authentication_status;

  private Enrolled enrollment_status;

  /**
   * @return authentication_status
   */
  public ParesStatus getAuthentication_status() {
    return this.authentication_status;
  }

  /**
   * @param authentication_status authentication_status to set
   * @return ThreeDSecureAuthenticationResponse
   */
  public <T extends ThreeDSecureAuthenticationResponse> T setAuthentication_status(
      ParesStatus authentication_status) {
    this.authentication_status = authentication_status;
    return (T) this;
  }

  /**
   * @return enrollment_status
   */
  public Enrolled getEnrollment_status() {
    return this.enrollment_status;
  }

  /**
   * @param enrollment_status enrollment_status to set
   * @return ThreeDSecureAuthenticationResponse
   */
  public <T extends ThreeDSecureAuthenticationResponse> T setEnrollment_status(
      Enrolled enrollment_status) {
    this.enrollment_status = enrollment_status;
    return (T) this;
  }
}
