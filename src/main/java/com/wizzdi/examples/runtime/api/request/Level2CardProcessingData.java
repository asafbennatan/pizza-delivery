package com.wizzdi.examples.runtime.api.request;

public class Level2CardProcessingData {

  private String invoice_id;

  private Money tax_total;

  /**
   * @return invoice_id
   */
  public String getInvoice_id() {
    return this.invoice_id;
  }

  /**
   * @param invoice_id invoice_id to set
   * @return Level2CardProcessingData
   */
  public <T extends Level2CardProcessingData> T setInvoice_id(String invoice_id) {
    this.invoice_id = invoice_id;
    return (T) this;
  }

  /**
   * @return tax_total
   */
  public Money getTax_total() {
    return this.tax_total;
  }

  /**
   * @param tax_total tax_total to set
   * @return Level2CardProcessingData
   */
  public <T extends Level2CardProcessingData> T setTax_total(Money tax_total) {
    this.tax_total = tax_total;
    return (T) this;
  }
}
