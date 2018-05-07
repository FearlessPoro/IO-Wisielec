import controllers.GameViewController;
import controllers.HangmanDelegate;
import controllers.MainViewController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HangMan extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HangmanDelegate.root = FXMLLoader.load(getClass().getResource("fxml/mainView.fxml"));

        Scene scene = new Scene(HangmanDelegate.root);

        HangmanDelegate.root.getStylesheets().add("stylesheet/dayStyle.css");

        stage.setScene(scene);
        stage.show();
    }
}
