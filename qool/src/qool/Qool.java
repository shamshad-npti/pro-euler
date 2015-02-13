package qool;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import qool.dao.DbException;
import qool.dao.DbManager;
import qool.dao.JPADbManager;
import qool.db.Course;

/**
 *
 * @author shame
 */
public class Qool extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * @throws qool.dao.DbException
     */
    public static void main(String[] args) throws DbException {
        DbManager db = JPADbManager.getDbManager();
        Course course = new Course(1);
        course.setTitle("Data Structure");
        db.save(course);
        if (db.exists(course)) {
            course = db.findById(course.getId(), Course.class);
            System.out.println(course);
        }
        launch(args);
    }
    
}
