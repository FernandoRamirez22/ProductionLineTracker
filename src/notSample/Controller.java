/**
 * This controller class responds to what SceneBuilder creates. Ties the two together.
 *
 * @author Fernando Ramirez
 */
package notSample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

  // Added database code

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/ProductDatabase"; // line

  //  Database credentials
  final String USER = "";
  final String PASS = "";
  Connection conn = null;
  Statement stmt = null;

  public void connectDatabase() {
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

  @FXML private Button btnAddProduct;

  @FXML private Button btnRecordProduction;

  @FXML private ChoiceBox<String> choiceBoxItemType;

  @FXML private ComboBox<Integer> comboBoxQuantitySelection;

  @FXML private ListView<String> listViewProductSelection;

  @FXML private TextArea textArea_ProductionLog;

  @FXML private TextField textFieldManufacturer;

  @FXML private TextField textFieldProductName;

  @FXML private ListView ProductionLine;

  @FXML private TableColumn<String, Product> productNameCol;

  @FXML private TableColumn<String, Product> productManufacturerCol;

  @FXML private TableColumn<String, Product> productTypeCol;

  @FXML private TableView<Product> prodTableView;

  /**
   * This method will populate the ____ with the products matching the format below, "name",
   * "manufacturer", "ItemType.Audio_MOBILE"
   *
   * @param event This event happens when clicked by "mouseclick".
   */
  @FXML
  public void addProductToList(MouseEvent event) {
    ObservableList<Product> productLine = FXCollections.observableArrayList();
    ;
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    productManufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    productTypeCol.setCellValueFactory(new PropertyValueFactory("itemType"));
    prodTableView.setItems(productLine);
    productLine.add(new Product("name", "manufacturer", ItemType.AUDIO_MOBILE) {});
    ProductionLine.getItems().add(productLine);
  }
  // Scene builder code^^

  /**
   * This function appends product data to the database, productDatabase. Populates database into
   * scene when mouse is clicked
   *
   * @param actionEvent This event happens when clicked by "mouseclick".
   */
  @FXML
  public void addProduct(ActionEvent actionEvent) {
    System.out.println("Product Added");
  }

  /**
   * This function records the log of the products.
   *
   * @param event This event happens when clicked by mouseclick.
   */
  @FXML
  void recordProduction(MouseEvent event) {

    TableView tableView = new TableView();

    TableColumn<String, Product> column1 = new TableColumn<>("NAME"); // name column
    column1.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<String, Product> column2 = new TableColumn<>("MANUFACTURER"); // manufacturer column
    column2.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

    TableColumn<String, Product> column3 = new TableColumn<>("TYPE"); // type column
    column3.setCellValueFactory(new PropertyValueFactory<>("type"));

    tableView.getColumns().add(column1);
    tableView.getColumns().add(column2);
    tableView.getColumns().add(column3);

    tableView.getItems().add(new Widget("ATARI 2600", "ATARI", ItemType.AUDIO));
  }

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

    // populates comboBox
    comboBoxQuantitySelection.setEditable(true);
    comboBoxQuantitySelection.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); // 1 - 10 options
    comboBoxQuantitySelection.getSelectionModel().selectFirst();
    for (ItemType item : ItemType.values()) {
      choiceBoxItemType.getItems().add(item + "'" + item.productType + "'");
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
  }
}
