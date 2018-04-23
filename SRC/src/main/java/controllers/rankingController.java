package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class rankingController {

    @FXML
    private Button returnButton;

    @FXML
    private TextArea rankingTableTextArea;

    @FXML
    void rankingTableAction(ActionEvent event) {

    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }
}
