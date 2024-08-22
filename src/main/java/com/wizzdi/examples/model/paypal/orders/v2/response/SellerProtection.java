package com.wizzdi.examples.model.paypal.orders.v2.response;

import java.util.List;

public class SellerProtection {

  private SellerProtectionStatus status;

  private List<SellerProtectionDisputeCategoriesItem> dispute_categories;

  /**
   * @return status
   */
  public SellerProtectionStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return SellerProtection
   */
  public <T extends SellerProtection> T setStatus(SellerProtectionStatus status) {
    this.status = status;
    return (T) this;
  }

  /**
   * @return dispute_categories
   */
  public List<SellerProtectionDisputeCategoriesItem> getDispute_categories() {
    return this.dispute_categories;
  }

  /**
   * @param dispute_categories dispute_categories to set
   * @return SellerProtection
   */
  public <T extends SellerProtection> T setDispute_categories(
      List<SellerProtectionDisputeCategoriesItem> dispute_categories) {
    this.dispute_categories = dispute_categories;
    return (T) this;
  }
}
