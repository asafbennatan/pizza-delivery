package com.wizzdi.examples.model.paypal.orders.v2.request;

public class NetworkTransactionReference {

  private String id;

  private String date;

  private CardBrand network;

  private String acquirer_reference_number;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return NetworkTransactionReference
   */
  public <T extends NetworkTransactionReference> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return date
   */
  public String getDate() {
    return this.date;
  }

  /**
   * @param date date to set
   * @return NetworkTransactionReference
   */
  public <T extends NetworkTransactionReference> T setDate(String date) {
    this.date = date;
    return (T) this;
  }

  /**
   * @return network
   */
  public CardBrand getNetwork() {
    return this.network;
  }

  /**
   * @param network network to set
   * @return NetworkTransactionReference
   */
  public <T extends NetworkTransactionReference> T setNetwork(CardBrand network) {
    this.network = network;
    return (T) this;
  }

  /**
   * @return acquirer_reference_number
   */
  public String getAcquirer_reference_number() {
    return this.acquirer_reference_number;
  }

  /**
   * @param acquirer_reference_number acquirer_reference_number to set
   * @return NetworkTransactionReference
   */
  public <T extends NetworkTransactionReference> T setAcquirer_reference_number(
      String acquirer_reference_number) {
    this.acquirer_reference_number = acquirer_reference_number;
    return (T) this;
  }
}
