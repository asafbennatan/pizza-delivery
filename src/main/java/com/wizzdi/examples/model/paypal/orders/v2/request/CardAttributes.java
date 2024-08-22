package com.wizzdi.examples.model.paypal.orders.v2.request;

public class CardAttributes {

  private Customer customer;

  private VaultInstructionBase vault;

  /**
   * @return customer
   */
  public Customer getCustomer() {
    return this.customer;
  }

  /**
   * @param customer customer to set
   * @return CardAttributes
   */
  public <T extends CardAttributes> T setCustomer(Customer customer) {
    this.customer = customer;
    return (T) this;
  }

  /**
   * @return vault
   */
  public VaultInstructionBase getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return CardAttributes
   */
  public <T extends CardAttributes> T setVault(VaultInstructionBase vault) {
    this.vault = vault;
    return (T) this;
  }
}
