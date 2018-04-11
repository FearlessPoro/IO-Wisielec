package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


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
    void exitAction(ActionEvent event) throws Exception {
        System.exit(0);
    }

    @FXML
    void newGameAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../categories.fxml")));
    }

}
