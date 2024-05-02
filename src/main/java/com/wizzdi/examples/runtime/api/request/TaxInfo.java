package com.wizzdi.examples.runtime.api.request;

public class TaxInfo {

  private String tax_id;

  private TaxInfoTaxIdType tax_id_type;

  /**
   * @return tax_id
   */
  public String getTax_id() {
    return this.tax_id;
  }

  /**
   * @param tax_id tax_id to set
   * @return TaxInfo
   */
  public <T extends TaxInfo> T setTax_id(String tax_id) {
    this.tax_id = tax_id;
    return (T) this;
  }

  /**
   * @return tax_id_type
   */
  public TaxInfoTaxIdType getTax_id_type() {
    return this.tax_id_type;
  }

  /**
   * @param tax_id_type tax_id_type to set
   * @return TaxInfo
   */
  public <T extends TaxInfo> T setTax_id_type(TaxInfoTaxIdType tax_id_type) {
    this.tax_id_type = tax_id_type;
    return (T) this;
  }
}
