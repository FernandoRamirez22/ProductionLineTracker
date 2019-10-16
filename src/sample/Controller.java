/**
 * This controller class responds to what SceneBuilder creates. Ties the two together.
 *
 * @author Fernando Ramirez
 */
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

  @FXML private Button btnAddProduct;

  @FXML private Button btnRecordProduction;

  @FXML private ChoiceBox<String> choiceBoxItemType;

  @FXML private ComboBox<Integer> comboBoxQuantitySelection;

  @FXML private ListView<String> listViewProductSelection;

  @FXML private TextArea textArea_ProductionLog;

  @FXML private TextField textFieldManufacturer;

  @FXML private TextField textFieldProductName;

  //Scene builder code^^

  /**
   * This function appends product data to the database, productDatabase.
   *
   * @param event This event happens when clicked by "mouseclick".
   */
  @FXML
  void addProduct(MouseEvent event) {
    String productName = textFieldProductName.getText(); // assign input to string
    String manufacturer = textFieldManufacturer.getText(); // assign input to string
    String sql =
        "INSERT INTO Product(type, manufacturer, name) VALUES ('AUDIO' , '"
            + manufacturer
            + "','"
            + productName
            + "')";
    Main.executeSql(sql); // send inputted string to sql
  }

  /**
   * This function records the log of the products.
   *
   * @param event This event happens when clicked by mouseclick.
   */
  @FXML
  void recordProduction(
      MouseEvent event) {} // empty method (currently) google style sees this as an issue

  /**
   * This function responds to the click on the comboBox_chooseQuantity button to let the user
   * choose the quantity.
   *
   * @param event This event is triggered when clicked by mouseclick.
   */
  @FXML
  void chooseQuantity(
      MouseEvent event) {} // empty method (currently) google style sees this as an issue

  /** This function initializes the comboBox_chooseQuantity elements inside the comboBox. */
  @FXML
  public void initialize() {
    // Comment
    comboBoxQuantitySelection.setEditable(true);
    comboBoxQuantitySelection.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 1 - 10 options
    comboBoxQuantitySelection.getSelectionModel().selectFirst();
  }
}
