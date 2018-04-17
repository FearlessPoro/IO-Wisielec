package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class rankingController {

    @FXML
    private Button returnButton;

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../mainView.fxml")));
    }

}
