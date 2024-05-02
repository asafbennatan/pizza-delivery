package com.wizzdi.examples.runtime.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProcessorResponseCvvCode {
  E,

  I,

  M,

  N,

  P,

  S,

  U,

  X,

  @JsonProperty("All others")
  All_others,

  @JsonProperty("0")
  _0,

  @JsonProperty("1")
  _1,

  @JsonProperty("2")
  _2,

  @JsonProperty("3")
  _3,

  @JsonProperty("4")
  _4
}
