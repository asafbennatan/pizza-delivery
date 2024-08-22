package com.wizzdi.examples.model.paypal.orders.v2.request;

public class VaultPaypalWalletBase {

  private VaultPaypalWalletBaseParent2CustomerType customer_type;

  private ShippingDetail shipping;

  private VaultPaypalWalletBaseParent2UsageType usage_type;

  private Object owner_id;

  private VaultPaypalWalletBaseParent2UsagePattern usage_pattern;

  private String description;

  private StoreInVaultInstruction store_in_vault;

  private Boolean permit_multiple_payment_tokens;

  /**
   * @return customer_type
   */
  public VaultPaypalWalletBaseParent2CustomerType getCustomer_type() {
    return this.customer_type;
  }

  /**
   * @param customer_type customer_type to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setCustomer_type(
      VaultPaypalWalletBaseParent2CustomerType customer_type) {
    this.customer_type = customer_type;
    return (T) this;
  }

  /**
   * @return shipping
   */
  public ShippingDetail getShipping() {
    return this.shipping;
  }

  /**
   * @param shipping shipping to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setShipping(ShippingDetail shipping) {
    this.shipping = shipping;
    return (T) this;
  }

  /**
   * @return usage_type
   */
  public VaultPaypalWalletBaseParent2UsageType getUsage_type() {
    return this.usage_type;
  }

  /**
   * @param usage_type usage_type to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setUsage_type(
      VaultPaypalWalletBaseParent2UsageType usage_type) {
    this.usage_type = usage_type;
    return (T) this;
  }

  /**
   * @return owner_id
   */
  public Object getOwner_id() {
    return this.owner_id;
  }

  /**
   * @param owner_id owner_id to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setOwner_id(Object owner_id) {
    this.owner_id = owner_id;
    return (T) this;
  }

  /**
   * @return usage_pattern
   */
  public VaultPaypalWalletBaseParent2UsagePattern getUsage_pattern() {
    return this.usage_pattern;
  }

  /**
   * @param usage_pattern usage_pattern to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setUsage_pattern(
      VaultPaypalWalletBaseParent2UsagePattern usage_pattern) {
    this.usage_pattern = usage_pattern;
    return (T) this;
  }

  /**
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description description to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setDescription(String description) {
    this.description = description;
    return (T) this;
  }

  /**
   * @return store_in_vault
   */
  public StoreInVaultInstruction getStore_in_vault() {
    return this.store_in_vault;
  }

  /**
   * @param store_in_vault store_in_vault to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setStore_in_vault(
      StoreInVaultInstruction store_in_vault) {
    this.store_in_vault = store_in_vault;
    return (T) this;
  }

  /**
   * @return permit_multiple_payment_tokens
   */
  public Boolean getPermit_multiple_payment_tokens() {
    return this.permit_multiple_payment_tokens;
  }

  /**
   * @param permit_multiple_payment_tokens permit_multiple_payment_tokens to set
   * @return VaultPaypalWalletBase
   */
  public <T extends VaultPaypalWalletBase> T setPermit_multiple_payment_tokens(
      Boolean permit_multiple_payment_tokens) {
    this.permit_multiple_payment_tokens = permit_multiple_payment_tokens;
    return (T) this;
  }
}
