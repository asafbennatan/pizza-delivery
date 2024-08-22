package com.wizzdi.examples.model.paypal.orders.v2.request;

public class VenmoWalletAttributes {

  private Customer customer;

  private VaultVenmoWalletBase vault;

  /**
   * @return customer
   */
  public Customer getCustomer() {
    return this.customer;
  }

  /**
   * @param customer customer to set
   * @return VenmoWalletAttributes
   */
  public <T extends VenmoWalletAttributes> T setCustomer(Customer customer) {
    this.customer = customer;
    return (T) this;
  }

  /**
   * @return vault
   */
  public VaultVenmoWalletBase getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return VenmoWalletAttributes
   */
  public <T extends VenmoWalletAttributes> T setVault(VaultVenmoWalletBase vault) {
    this.vault = vault;
    return (T) this;
  }
}
