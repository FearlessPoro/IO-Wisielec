package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import logic.Game;
import logic.GameTypes;

import java.io.File;
import java.net.URL;

public class MainViewController {

    @FXML
    public ImageView logoPane;

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
    private Button dayModeButton2;


    @FXML
    void newGameAction(ActionEvent event) throws Exception {
        GameViewController.type = GameTypes.NEW_GAME;
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/gameMode.fxml")));
    }

    @FXML
    void restoreGameAction(ActionEvent event) throws Exception{
        GameTypes.timed = false;
        GameViewController.type = GameTypes.RESTORED_GAME;
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/gameView.fxml")));
    }

    @FXML
    void rankingAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/ranking.fxml")));
    }

    @FXML
    void addPasswordAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/categoriesToAddPassword.fxml")));
    }

    @FXML
    void exitAction(ActionEvent event) throws Exception {
        System.exit(0);
    }

    @FXML
    void dayModeAction2(ActionEvent event) {
        if(HangmanDelegate.nightModeOn){
            HangmanDelegate.root.getStylesheets().clear();
            HangmanDelegate.root.getStylesheets().add("stylesheet/dayStyle.css");
            HangmanDelegate.nightModeOn = false;
        }
        else {
            HangmanDelegate.root.getStylesheets().clear();
            HangmanDelegate.root.getStylesheets().add("stylesheet/nightStyle.css");
            HangmanDelegate.nightModeOn = true;
        }
    }

    @FXML
    void initialize() {
        URL resource = Game.class.getResource("/");
        String dir = "";
        File f = null;

        if (resource != null) {
            dir += resource.getFile();
            dir += "/game.ser";
            f = new File(dir);
        }

        if (f == null || !f.exists()) {
            restoreGameButton.setDisable(true);
        }
    }
}
