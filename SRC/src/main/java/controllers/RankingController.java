package controllers;

import entity.RankEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import logic.Game;

public class RankingController {

    @FXML
    private Button returnButton;

    @FXML
    private TextArea rankingTableTextArea;

    @FXML
    void rankingTableAction(ActionEvent event) {
    }

    public void initialize() {
        rankingTableTextArea.setText(Game.getRankEntity());
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }
}
