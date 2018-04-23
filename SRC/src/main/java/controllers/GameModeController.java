package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class GameModeController {

    @FXML
    private Button normalModeButton;

    @FXML
    private Button timeModeButton;

    @FXML
    private Button returnButton;

    @FXML
    void normalModeAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/levelOfDifficulty.fxml")));
    }

    @FXML
    void timeModeAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/levelOfDifficulty.fxml")));
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }

}
