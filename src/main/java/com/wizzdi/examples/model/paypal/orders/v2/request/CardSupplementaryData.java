package com.wizzdi.examples.model.paypal.orders.v2.request;

public class CardSupplementaryData {

  private Level2CardProcessingData level_2;

  private Level3CardProcessingData level_3;

  /**
   * @return level_2
   */
  public Level2CardProcessingData getLevel_2() {
    return this.level_2;
  }

  /**
   * @param level_2 level_2 to set
   * @return CardSupplementaryData
   */
  public <T extends CardSupplementaryData> T setLevel_2(Level2CardProcessingData level_2) {
    this.level_2 = level_2;
    return (T) this;
  }

  /**
   * @return level_3
   */
  public Level3CardProcessingData getLevel_3() {
    return this.level_3;
  }

  /**
   * @param level_3 level_3 to set
   * @return CardSupplementaryData
   */
  public <T extends CardSupplementaryData> T setLevel_3(Level3CardProcessingData level_3) {
    this.level_3 = level_3;
    return (T) this;
  }
}
