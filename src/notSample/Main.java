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
import java.util.Date;
import java.sql.Statement;

class Main extends Application {
  /**
   * Set the scene for GUI program.
   *
   *
   * @param primaryStage
   * */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionLine.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    Scene scene = new Scene(root, 500, 450);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
