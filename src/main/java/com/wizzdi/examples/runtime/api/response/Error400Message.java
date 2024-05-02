package com.wizzdi.examples.runtime.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Error400Message {
  @JsonProperty("Request is not well-formed, syntactically incorrect, or violates schema.")
  Request_is_not_well_formed__syntactically_incorrect__or_violates_schema_
}
