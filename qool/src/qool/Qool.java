package qool;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import qool.dao.DbException;
import qool.dao.DbManager;
import qool.dao.JPADbManager;
import qool.view.admin.AdminView;

/**
 *
 * @author shame
 */
public class Qool extends Application {
    private DbManager dbManager = JPADbManager.getDbManager();

    @Override
    public void start(Stage primaryStage) throws IOException {
        AdminView view = new AdminView(dbManager);
        Scene scene = new Scene(view.createView(), 800, 700);
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
