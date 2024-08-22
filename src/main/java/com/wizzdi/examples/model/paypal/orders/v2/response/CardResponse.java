package com.wizzdi.examples.model.paypal.orders.v2.response;

import com.wizzdi.examples.model.paypal.orders.v2.request.CardBrand;
import java.util.List;

public class CardResponse {

  private String name;

  private String last_digits;

  private CardBrand brand;

  private List<CardBrand> available_networks;

  private CardResponseType type;

  private AuthenticationResponse authentication_result;

  private CardAttributesResponse attributes;

  private CardFromRequest from_request;

  private String expiry;

  private BinDetails bin_details;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return last_digits
   */
  public String getLast_digits() {
    return this.last_digits;
  }

  /**
   * @param last_digits last_digits to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setLast_digits(String last_digits) {
    this.last_digits = last_digits;
    return (T) this;
  }

  /**
   * @return brand
   */
  public CardBrand getBrand() {
    return this.brand;
  }

  /**
   * @param brand brand to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setBrand(CardBrand brand) {
    this.brand = brand;
    return (T) this;
  }

  /**
   * @return available_networks
   */
  public List<CardBrand> getAvailable_networks() {
    return this.available_networks;
  }

  /**
   * @param available_networks available_networks to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setAvailable_networks(List<CardBrand> available_networks) {
    this.available_networks = available_networks;
    return (T) this;
  }

  /**
   * @return type
   */
  public CardResponseType getType() {
    return this.type;
  }

  /**
   * @param type type to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setType(CardResponseType type) {
    this.type = type;
    return (T) this;
  }

  /**
   * @return authentication_result
   */
  public AuthenticationResponse getAuthentication_result() {
    return this.authentication_result;
  }

  /**
   * @param authentication_result authentication_result to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setAuthentication_result(
      AuthenticationResponse authentication_result) {
    this.authentication_result = authentication_result;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public CardAttributesResponse getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setAttributes(CardAttributesResponse attributes) {
    this.attributes = attributes;
    return (T) this;
  }

  /**
   * @return from_request
   */
  public CardFromRequest getFrom_request() {
    return this.from_request;
  }

  /**
   * @param from_request from_request to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setFrom_request(CardFromRequest from_request) {
    this.from_request = from_request;
    return (T) this;
  }

  /**
   * @return expiry
   */
  public String getExpiry() {
    return this.expiry;
  }

  /**
   * @param expiry expiry to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setExpiry(String expiry) {
    this.expiry = expiry;
    return (T) this;
  }

  /**
   * @return bin_details
   */
  public BinDetails getBin_details() {
    return this.bin_details;
  }

  /**
   * @param bin_details bin_details to set
   * @return CardResponse
   */
  public <T extends CardResponse> T setBin_details(BinDetails bin_details) {
    this.bin_details = bin_details;
    return (T) this;
  }
}
