package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PaymentSource {

  private CardRequest card;

  private Token token;

  private PaypalWallet paypal;

  private BancontactRequest bancontact;

  private BlikRequest blik;

  private EpsRequest eps;

  private GiropayRequest giropay;

  private IdealRequest ideal;

  private MybankRequest mybank;

  private P24Request p24;

  private SofortRequest sofort;

  private TrustlyRequest trustly;

  private ApplePayRequest apple_pay;

  private Object google_pay;

  private VenmoWalletRequest venmo;

  /**
   * @return card
   */
  public CardRequest getCard() {
    return this.card;
  }

  /**
   * @param card card to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setCard(CardRequest card) {
    this.card = card;
    return (T) this;
  }

  /**
   * @return token
   */
  public Token getToken() {
    return this.token;
  }

  /**
   * @param token token to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setToken(Token token) {
    this.token = token;
    return (T) this;
  }

  /**
   * @return paypal
   */
  public PaypalWallet getPaypal() {
    return this.paypal;
  }

  /**
   * @param paypal paypal to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setPaypal(PaypalWallet paypal) {
    this.paypal = paypal;
    return (T) this;
  }

  /**
   * @return bancontact
   */
  public BancontactRequest getBancontact() {
    return this.bancontact;
  }

  /**
   * @param bancontact bancontact to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setBancontact(BancontactRequest bancontact) {
    this.bancontact = bancontact;
    return (T) this;
  }

  /**
   * @return blik
   */
  public BlikRequest getBlik() {
    return this.blik;
  }

  /**
   * @param blik blik to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setBlik(BlikRequest blik) {
    this.blik = blik;
    return (T) this;
  }

  /**
   * @return eps
   */
  public EpsRequest getEps() {
    return this.eps;
  }

  /**
   * @param eps eps to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setEps(EpsRequest eps) {
    this.eps = eps;
    return (T) this;
  }

  /**
   * @return giropay
   */
  public GiropayRequest getGiropay() {
    return this.giropay;
  }

  /**
   * @param giropay giropay to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setGiropay(GiropayRequest giropay) {
    this.giropay = giropay;
    return (T) this;
  }

  /**
   * @return ideal
   */
  public IdealRequest getIdeal() {
    return this.ideal;
  }

  /**
   * @param ideal ideal to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setIdeal(IdealRequest ideal) {
    this.ideal = ideal;
    return (T) this;
  }

  /**
   * @return mybank
   */
  public MybankRequest getMybank() {
    return this.mybank;
  }

  /**
   * @param mybank mybank to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setMybank(MybankRequest mybank) {
    this.mybank = mybank;
    return (T) this;
  }

  /**
   * @return p24
   */
  public P24Request getP24() {
    return this.p24;
  }

  /**
   * @param p24 p24 to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setP24(P24Request p24) {
    this.p24 = p24;
    return (T) this;
  }

  /**
   * @return sofort
   */
  public SofortRequest getSofort() {
    return this.sofort;
  }

  /**
   * @param sofort sofort to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setSofort(SofortRequest sofort) {
    this.sofort = sofort;
    return (T) this;
  }

  /**
   * @return trustly
   */
  public TrustlyRequest getTrustly() {
    return this.trustly;
  }

  /**
   * @param trustly trustly to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setTrustly(TrustlyRequest trustly) {
    this.trustly = trustly;
    return (T) this;
  }

  /**
   * @return apple_pay
   */
  public ApplePayRequest getApple_pay() {
    return this.apple_pay;
  }

  /**
   * @param apple_pay apple_pay to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setApple_pay(ApplePayRequest apple_pay) {
    this.apple_pay = apple_pay;
    return (T) this;
  }

  /**
   * @return google_pay
   */
  public Object getGoogle_pay() {
    return this.google_pay;
  }

  /**
   * @param google_pay google_pay to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setGoogle_pay(Object google_pay) {
    this.google_pay = google_pay;
    return (T) this;
  }

  /**
   * @return venmo
   */
  public VenmoWalletRequest getVenmo() {
    return this.venmo;
  }

  /**
   * @param venmo venmo to set
   * @return PaymentSource
   */
  public <T extends PaymentSource> T setVenmo(VenmoWalletRequest venmo) {
    this.venmo = venmo;
    return (T) this;
  }
}
