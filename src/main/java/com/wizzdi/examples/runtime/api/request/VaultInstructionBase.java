package com.wizzdi.examples.runtime.api.request;

public class VaultInstructionBase {

  private StoreInVaultInstruction store_in_vault;

  /**
   * @return store_in_vault
   */
  public StoreInVaultInstruction getStore_in_vault() {
    return this.store_in_vault;
  }

  /**
   * @param store_in_vault store_in_vault to set
   * @return VaultInstructionBase
   */
  public <T extends VaultInstructionBase> T setStore_in_vault(
      StoreInVaultInstruction store_in_vault) {
    this.store_in_vault = store_in_vault;
    return (T) this;
  }
}
