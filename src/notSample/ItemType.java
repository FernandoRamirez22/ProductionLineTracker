package notSample;

public enum ItemType {
  AUDIO("AU"),

  VISUAL("VI"),

  AUDIO_MOBILE("AM"),

  VISUAL_MOBILE("VM");

  private String productType;

  ItemType(String productType) {
    this.productType = productType;
  }

  public String getProductType() {

    return this.productType;
  }
}
