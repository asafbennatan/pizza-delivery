package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PaypalWalletAttributes {

  private PaypalWalletCustomer customer;

  private VaultPaypalWalletBase vault;

  /**
   * @return customer
   */
  public PaypalWalletCustomer getCustomer() {
    return this.customer;
  }

  /**
   * @param customer customer to set
   * @return PaypalWalletAttributes
   */
  public <T extends PaypalWalletAttributes> T setCustomer(PaypalWalletCustomer customer) {
    this.customer = customer;
    return (T) this;
  }

  /**
   * @return vault
   */
  public VaultPaypalWalletBase getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return PaypalWalletAttributes
   */
  public <T extends PaypalWalletAttributes> T setVault(VaultPaypalWalletBase vault) {
    this.vault = vault;
    return (T) this;
  }
}
