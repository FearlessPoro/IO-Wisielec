import controllers.HangmanDelegate;
import entity.RankEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Game;


public class HangMan extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HangmanDelegate.root = FXMLLoader.load(getClass().getResource("fxml/mainView.fxml"));

        Game.setRank(RankEntity.deserialize());

        Scene scene = new Scene(HangmanDelegate.root);

        HangmanDelegate.root.getStylesheets().add("stylesheet/dayStyle.css");

        stage.setMaxWidth(950);
        stage.setMaxHeight(638);
        stage.setScene(scene);
        stage.show();


    }
}
