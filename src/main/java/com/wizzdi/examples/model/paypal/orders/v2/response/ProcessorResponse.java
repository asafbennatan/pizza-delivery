package com.wizzdi.examples.model.paypal.orders.v2.response;

public class ProcessorResponse {

  private ProcessorResponseAvsCode avs_code;

  private ProcessorResponseCvvCode cvv_code;

  private ProcessorResponseResponseCode response_code;

  private ProcessorResponsePaymentAdviceCode payment_advice_code;

  /**
   * @return avs_code
   */
  public ProcessorResponseAvsCode getAvs_code() {
    return this.avs_code;
  }

  /**
   * @param avs_code avs_code to set
   * @return ProcessorResponse
   */
  public <T extends ProcessorResponse> T setAvs_code(ProcessorResponseAvsCode avs_code) {
    this.avs_code = avs_code;
    return (T) this;
  }

  /**
   * @return cvv_code
   */
  public ProcessorResponseCvvCode getCvv_code() {
    return this.cvv_code;
  }

  /**
   * @param cvv_code cvv_code to set
   * @return ProcessorResponse
   */
  public <T extends ProcessorResponse> T setCvv_code(ProcessorResponseCvvCode cvv_code) {
    this.cvv_code = cvv_code;
    return (T) this;
  }

  /**
   * @return response_code
   */
  public ProcessorResponseResponseCode getResponse_code() {
    return this.response_code;
  }

  /**
   * @param response_code response_code to set
   * @return ProcessorResponse
   */
  public <T extends ProcessorResponse> T setResponse_code(
      ProcessorResponseResponseCode response_code) {
    this.response_code = response_code;
    return (T) this;
  }

  /**
   * @return payment_advice_code
   */
  public ProcessorResponsePaymentAdviceCode getPayment_advice_code() {
    return this.payment_advice_code;
  }

  /**
   * @param payment_advice_code payment_advice_code to set
   * @return ProcessorResponse
   */
  public <T extends ProcessorResponse> T setPayment_advice_code(
      ProcessorResponsePaymentAdviceCode payment_advice_code) {
    this.payment_advice_code = payment_advice_code;
    return (T) this;
  }
}
