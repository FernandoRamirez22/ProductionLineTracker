package notSample;

import java.util.Date;

class Main {
  public static void main(String[] args) {

    Product productProduced = new Widget("iPod", "Apple", ItemType.AUDIO);

    // test constructor used when creating production records from user interface
    int numProduced = 3; // this will come from the combobox in the UI
    int itemCount = 0;

    for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
      ProductionRecord pr = new ProductionRecord(productProduced, itemCount++);
      // using the iterator as the product id for testing
      System.out.println(pr.toString());
    }
  }
}
