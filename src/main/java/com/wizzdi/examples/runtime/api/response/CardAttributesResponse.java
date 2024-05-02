package com.wizzdi.examples.runtime.api.response;

public class CardAttributesResponse {

  private VaultResponse vault;

  /**
   * @return vault
   */
  public VaultResponse getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return CardAttributesResponse
   */
  public <T extends CardAttributesResponse> T setVault(VaultResponse vault) {
    this.vault = vault;
    return (T) this;
  }
}
