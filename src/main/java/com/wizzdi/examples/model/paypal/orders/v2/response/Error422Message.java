package com.wizzdi.examples.model.paypal.orders.v2.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Error422Message {
  @JsonProperty(
      "The requested action could not be performed, semantically incorrect, or failed business"
          + " validation.")
  The_requested_action_could_not_be_performed__semantically_incorrect__or_failed_business_validation_
}
