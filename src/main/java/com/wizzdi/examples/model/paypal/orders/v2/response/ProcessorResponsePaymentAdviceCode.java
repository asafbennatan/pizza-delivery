package com.wizzdi.examples.model.paypal.orders.v2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProcessorResponsePaymentAdviceCode {
  @JsonProperty("01")
  _01,

  @JsonProperty("02")
  _02,

  @JsonProperty("03")
  _03,

  @JsonProperty("21")
  _21
}
