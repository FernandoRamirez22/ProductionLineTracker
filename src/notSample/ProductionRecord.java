package notSample;
import java.util.Date;

public class ProductionRecord {
    int productionNum;
    int productID;
    String serialNum;
    Date prodDate;

    public ProductionRecord(int productID) {
        this.productID = productID;
        productionNum = 0;
        serialNum = "0";
        prodDate = new Date();
    }

    public ProductionRecord(
            int productionNum, int productID, String serialNum, Date prodDate) {
        this.productID = productID;
        this.serialNum = serialNum;
        this.prodDate = prodDate;
    }



    // Getters
    public int getProductionNum() {
        return productionNum;
    }

    public int getProductID() {
        return productID;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public Date getProdDate() {
        return prodDate;
    }

    // Setters
    public void setProductionNum(int productionNum) {
        this.productionNum = productionNum;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setSerialNum(String serialNumber) {
        this.serialNum = serialNum;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    @Override
    public String toString(){
        return String.format("Prod. Num: %s Product ID: %s Serial Num: %s Date: %s", productionNum, productID, serialNum, prodDate);
    }

}
