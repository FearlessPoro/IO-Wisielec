import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HangMan extends Application {

    static AnchorPane root;

    public static void main(String[] args) {
        launch(args);
//        Game game = new Game();
//        game.start();
    }

 @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("mainView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
