package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class mainViewController {

    @FXML
    private ImageView logoPane;

    @FXML
    private Pane menuPane;

    @FXML
    private Button newGameButton;

    @FXML
    private Button restoreGameButton;

    @FXML
    private Button rankingButton;

    @FXML
    private Button addPasswordButton;

    @FXML
    private Button exitButton;

    @FXML
    private ToggleButton nightModeButton;

    @FXML
    void newGameAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../gameMode.fxml")));
    }

    @FXML
    void restoreGameAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../gameView.fxml")));
    }

    @FXML
    void rankingAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../ranking.fxml")));
    }

    @FXML
    void addPasswordAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../categoriesToAddPassword.fxml")));
    }

    @FXML
    void exitAction(ActionEvent event) throws Exception {
        System.exit(0);
    }

    @FXML
    void nightModeAction(ActionEvent event) throws Exception{

    }
}
