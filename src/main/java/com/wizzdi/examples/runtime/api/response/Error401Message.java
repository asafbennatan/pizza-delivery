package com.wizzdi.examples.runtime.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Error401Message {
  @JsonProperty(
      "Authentication failed due to missing authorization header, or invalid authentication"
          + " credentials.")
  Authentication_failed_due_to_missing_authorization_header__or_invalid_authentication_credentials_
}
