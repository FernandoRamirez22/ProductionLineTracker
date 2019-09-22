package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class Controller {

  @FXML private ComboBox<Integer> DisplayList;

  /**
   * DiplayProduction will print "Product" when clicked
   *
   * @param event
   */
  @FXML
  void DiplayProduction(MouseEvent event) {
    System.out.println("Product");
  }

  /**
   * RecordProduct will print "Recorded" when clicked
   *
   * @param event
   */
  @FXML
  void RecordProduct(MouseEvent event) {
    System.out.println("Recorded");
  }

  /**
   * DisplayList will display dataBase list when clicked
   *
   * @param event
   */
  @FXML
  void DisplayList(MouseEvent event) {}

  /** Initialize() initiates comboBox on scene builder */
  @FXML
  void initialize() {
    DisplayList.setEditable(true);
    DisplayList.getItems().add(1);
    DisplayList.getItems().add(2);
    DisplayList.getItems().add(3);
    DisplayList.getItems().add(4);
    DisplayList.getItems().add(5);
    DisplayList.getItems().add(6);
    DisplayList.getItems().add(7);
    DisplayList.getItems().add(8);
    DisplayList.getItems().add(9);
    DisplayList.getItems().add(10);
    DisplayList.getSelectionModel().selectFirst();
  }
}
