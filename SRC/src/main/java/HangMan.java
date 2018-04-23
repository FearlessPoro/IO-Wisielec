import controllers.HangmanDelegate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HangMan extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HangmanDelegate.root = FXMLLoader.load(getClass().getResource("fxml/mainView.fxml"));

        Scene scene = new Scene(HangmanDelegate.root);

        stage.setScene(scene);
        stage.show();
    }
}
