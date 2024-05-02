package com.wizzdi.examples.runtime.api.response;

import java.util.List;

public class PaypalWalletAttributesResponse {

  private PaypalWalletVaultResponse vault;

  private List<CobrandedCard> cobranded_cards;

  /**
   * @return vault
   */
  public PaypalWalletVaultResponse getVault() {
    return this.vault;
  }

  /**
   * @param vault vault to set
   * @return PaypalWalletAttributesResponse
   */
  public <T extends PaypalWalletAttributesResponse> T setVault(PaypalWalletVaultResponse vault) {
    this.vault = vault;
    return (T) this;
  }

  /**
   * @return cobranded_cards
   */
  public List<CobrandedCard> getCobranded_cards() {
    return this.cobranded_cards;
  }

  /**
   * @param cobranded_cards cobranded_cards to set
   * @return PaypalWalletAttributesResponse
   */
  public <T extends PaypalWalletAttributesResponse> T setCobranded_cards(
      List<CobrandedCard> cobranded_cards) {
    this.cobranded_cards = cobranded_cards;
    return (T) this;
  }
}
