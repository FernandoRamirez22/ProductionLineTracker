/**
 * This controller class responds to what SceneBuilder creates. Ties the two together.
 *
 * @author Fernando Ramirez
 */
package notSample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

  @FXML private Button btnAddProduct;

  @FXML private Button btnRecordProduction;

  @FXML private ChoiceBox<ItemType> choiceBoxItemType;

  @FXML private ComboBox<Integer> comboBoxQuantitySelection;

  @FXML private ListView<String> listViewProductSelection;

  @FXML private TextArea textArea_ProductionLog;

  @FXML private TextField textFieldManufacturer;

  @FXML private TextField textFieldProductName;

  //Scene builder code^^

  /**
   * This function appends product data to the database, productDatabase.
   *Populates database into scene when mouse is clicked
   * @param event This event happens when clicked by "mouseclick".
   */
  @FXML
  static void addProduct(ActionEvent event) {
    // Added database code


    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductDatabase"; // line

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // STEP 3: Execute a query
      stmt = conn.createStatement(); // possible bug here (soon to be used)

      // STEP 4: Clean-up environment

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  /**
   * This function will initiate SQL to manipulate and interact with database
   *
   * @param sql SQL string argument.
   */
  public void executeSql(String sql) {
    try {
      Statement stmt = null; // initialize statement
      stmt.executeUpdate(sql);
    } catch (Exception e) {
      e.printStackTrace();
    }
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
    for(ItemType item: ItemType.values()){
      choiceBoxItemType.getItems().add(item);
    }


    /**
     * Driver function will declare database and start the program
     *
     * @param args array for the driver class
     */

    String productName = textFieldProductName.getText(); // assign input to string
    String manufacturer = textFieldManufacturer.getText(); // assign input to string
    String sql =
            "INSERT INTO Product(type, manufacturer, name) VALUES ('AUDIO' , '"
                    + manufacturer
                    + "','"
                    + productName
                    + "')";
    executeSql(sql); // send inputted string to sql

  }
}
