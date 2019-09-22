package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

  /**
   * Setting the stage for the scene
   *
   * @param primaryStage
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  /**
   * Database connectivity
   *
   * @param args
   */
  public static void main(String[] args) {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:.res/ProductDatabase";
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

      stmt = conn.createStatement();

      String sql = "SELECT * FROM JOBS";

      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {

        System.out.println(rs.getString(1));
      }

      // STEP 4: Clean-up environment

      stmt.close();

      conn.close();

    } catch (ClassNotFoundException e) {

      e.printStackTrace();

    } catch (SQLException e) {

      e.printStackTrace();
    }

    launch(args);
  }
}
