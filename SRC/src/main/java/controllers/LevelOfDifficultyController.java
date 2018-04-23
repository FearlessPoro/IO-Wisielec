package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class LevelOfDifficultyController {

    @FXML
    private Button easyLevelButton;

    @FXML
    private Button mediumLevelButton;

    @FXML
    private Button hardLevelButton;

    @FXML
    private Button returnButton;

    @FXML
    void easyLevelAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/categories.fxml")));
    }

    @FXML
    void mediumLevelAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/categories.fxml")));
    }

    @FXML
    void hardLevelAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/categories.fxml")));
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }

}
