package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("design.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();     // this is controller !

        primaryStage.setTitle("Pineco");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        // on close request, save current note
        primaryStage.setOnCloseRequest(e -> {
            controller.saveNoteBtnClicked();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
