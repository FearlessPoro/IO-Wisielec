

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class mainViewController {

    @FXML
    private ImageView logoPane;

    @FXML
    private Pane menuPane;

    @FXML
    private Button newGameButton;

    @FXML
    private Button bestScoresButton;

    @FXML
    private Button exitButton;

    @FXML
    void bestScoresAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) throws Exception{
        System.exit(0);
    }

    @FXML
    void newGameAction(ActionEvent event) throws Exception{
        HangMan.root.getChildren().add(FXMLLoader.load(getClass().getResource("categories.fxml")));
    }

}
