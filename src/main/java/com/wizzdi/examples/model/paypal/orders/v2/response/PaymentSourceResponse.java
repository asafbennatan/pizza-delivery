package com.wizzdi.examples.model.paypal.orders.v2.response;

public class PaymentSourceResponse {

  private CardResponse card;

  private PaypalWalletResponse paypal;

  private Bancontact bancontact;

  private Blik blik;

  private Eps eps;

  private Giropay giropay;

  private Ideal ideal;

  private Mybank mybank;

  private P24 p24;

  private Sofort sofort;

  private Trustly trustly;

  private VenmoWalletResponse venmo;

  /**
   * @return card
   */
  public CardResponse getCard() {
    return this.card;
  }

  /**
   * @param card card to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setCard(CardResponse card) {
    this.card = card;
    return (T) this;
  }

  /**
   * @return paypal
   */
  public PaypalWalletResponse getPaypal() {
    return this.paypal;
  }

  /**
   * @param paypal paypal to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setPaypal(PaypalWalletResponse paypal) {
    this.paypal = paypal;
    return (T) this;
  }

  /**
   * @return bancontact
   */
  public Bancontact getBancontact() {
    return this.bancontact;
  }

  /**
   * @param bancontact bancontact to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setBancontact(Bancontact bancontact) {
    this.bancontact = bancontact;
    return (T) this;
  }

  /**
   * @return blik
   */
  public Blik getBlik() {
    return this.blik;
  }

  /**
   * @param blik blik to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setBlik(Blik blik) {
    this.blik = blik;
    return (T) this;
  }

  /**
   * @return eps
   */
  public Eps getEps() {
    return this.eps;
  }

  /**
   * @param eps eps to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setEps(Eps eps) {
    this.eps = eps;
    return (T) this;
  }

  /**
   * @return giropay
   */
  public Giropay getGiropay() {
    return this.giropay;
  }

  /**
   * @param giropay giropay to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setGiropay(Giropay giropay) {
    this.giropay = giropay;
    return (T) this;
  }

  /**
   * @return ideal
   */
  public Ideal getIdeal() {
    return this.ideal;
  }

  /**
   * @param ideal ideal to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setIdeal(Ideal ideal) {
    this.ideal = ideal;
    return (T) this;
  }

  /**
   * @return mybank
   */
  public Mybank getMybank() {
    return this.mybank;
  }

  /**
   * @param mybank mybank to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setMybank(Mybank mybank) {
    this.mybank = mybank;
    return (T) this;
  }

  /**
   * @return p24
   */
  public P24 getP24() {
    return this.p24;
  }

  /**
   * @param p24 p24 to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setP24(P24 p24) {
    this.p24 = p24;
    return (T) this;
  }

  /**
   * @return sofort
   */
  public Sofort getSofort() {
    return this.sofort;
  }

  /**
   * @param sofort sofort to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setSofort(Sofort sofort) {
    this.sofort = sofort;
    return (T) this;
  }

  /**
   * @return trustly
   */
  public Trustly getTrustly() {
    return this.trustly;
  }

  /**
   * @param trustly trustly to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setTrustly(Trustly trustly) {
    this.trustly = trustly;
    return (T) this;
  }

  /**
   * @return venmo
   */
  public VenmoWalletResponse getVenmo() {
    return this.venmo;
  }

  /**
   * @param venmo venmo to set
   * @return PaymentSourceResponse
   */
  public <T extends PaymentSourceResponse> T setVenmo(VenmoWalletResponse venmo) {
    this.venmo = venmo;
    return (T) this;
  }
}
