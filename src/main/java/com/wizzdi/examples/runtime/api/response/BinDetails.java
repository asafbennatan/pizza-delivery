package com.wizzdi.examples.runtime.api.response;

import java.util.List;

public class BinDetails {

  private String bin;

  private String issuing_bank;

  private String bin_country_code;

  private List<String> products;

  /**
   * @return bin
   */
  public String getBin() {
    return this.bin;
  }

  /**
   * @param bin bin to set
   * @return BinDetails
   */
  public <T extends BinDetails> T setBin(String bin) {
    this.bin = bin;
    return (T) this;
  }

  /**
   * @return issuing_bank
   */
  public String getIssuing_bank() {
    return this.issuing_bank;
  }

  /**
   * @param issuing_bank issuing_bank to set
   * @return BinDetails
   */
  public <T extends BinDetails> T setIssuing_bank(String issuing_bank) {
    this.issuing_bank = issuing_bank;
    return (T) this;
  }

  /**
   * @return bin_country_code
   */
  public String getBin_country_code() {
    return this.bin_country_code;
  }

  /**
   * @param bin_country_code bin_country_code to set
   * @return BinDetails
   */
  public <T extends BinDetails> T setBin_country_code(String bin_country_code) {
    this.bin_country_code = bin_country_code;
    return (T) this;
  }

  /**
   * @return products
   */
  public List<String> getProducts() {
    return this.products;
  }

  /**
   * @param products products to set
   * @return BinDetails
   */
  public <T extends BinDetails> T setProducts(List<String> products) {
    this.products = products;
    return (T) this;
  }
}
