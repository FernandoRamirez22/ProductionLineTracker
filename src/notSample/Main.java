/**
 * The driver class will launch the ProductionLineTracker program.
 *
 * @author Fernando Ramirez
 */
package notSample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Statement;

public class Main extends Application {


  static Statement stmt = null;

  /**
   * Function initiates ProductionLineTracker program.
   *
   * @param primaryStage This is the GUI stage.
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionWithTabs.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  } // start






}
