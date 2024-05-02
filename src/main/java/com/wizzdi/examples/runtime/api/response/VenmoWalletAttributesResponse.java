package com.wizzdi.examples.runtime.api.response;

public class VenmoWalletAttributesResponse {

  private VaultResponse vault;

  /**
   * @return vault
   */
  public VaultResponse getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return VenmoWalletAttributesResponse
   */
  public <T extends VenmoWalletAttributesResponse> T setVault(VaultResponse vault) {
    this.vault = vault;
    return (T) this;
  }
}
