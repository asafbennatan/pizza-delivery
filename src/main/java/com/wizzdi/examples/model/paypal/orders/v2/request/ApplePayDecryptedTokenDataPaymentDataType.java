package com.wizzdi.examples.model.paypal.orders.v2.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApplePayDecryptedTokenDataPaymentDataType {
  @JsonProperty("3DSECURE")
  _3DSECURE,

  EMV
}
