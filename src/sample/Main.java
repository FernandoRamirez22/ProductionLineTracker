/**
 * The driver class will launch the ProductionLineTracker program.
 *
 * @author Fernando Ramirez
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  } // start

  /**
   * Driver function will declare database and start the program
   *
   * @param args array for the driver class
   */
  public static void main(String[] args) {

    // database
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

    launch(args);
  } // This the main

  /**
   * This function will initiate SQL to manipulate and interact with database
   *
   * @param sql SQL string argument.
   */
  public static void executeSql(String sql) {
    try {
      Statement stmt = null; // initialize statement
      stmt.executeUpdate(sql);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
