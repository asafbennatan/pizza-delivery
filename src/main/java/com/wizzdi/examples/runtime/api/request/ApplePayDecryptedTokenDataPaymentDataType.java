package com.wizzdi.examples.runtime.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApplePayDecryptedTokenDataPaymentDataType {
  @JsonProperty("3DSECURE")
  _3DSECURE,

  EMV
}
