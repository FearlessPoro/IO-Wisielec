package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import logic.LevelDifficulty;

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
        GameViewController.level = LevelDifficulty.EASY;
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/categories.fxml")));
    }

    @FXML
    void mediumLevelAction(ActionEvent event) throws Exception{
        GameViewController.level = LevelDifficulty.MEDIUM;
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/categories.fxml")));
    }

    @FXML
    void hardLevelAction(ActionEvent event) throws Exception{
        GameViewController.level = LevelDifficulty.HARD;
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/categories.fxml")));
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/mainView.fxml")));
    }

}
