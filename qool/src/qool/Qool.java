package qool;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import qool.dao.DbException;

/**
 *
 * @author shame
 */
public class Qool extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("CourseView.fxml"));
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * @throws qool.dao.DbException
     */
    public static void main(String[] args) throws DbException {
        launch(args);
    }
    
}
