package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

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
    public ToggleButton nightModeButton;

    @FXML
    private ToggleGroup nightMode;

    @FXML
    private ToggleButton dayModeButton;

    @FXML
    void newGameAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameMode.fxml")));
    }

    @FXML
    void restoreGameAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void rankingAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/ranking.fxml")));
    }

    @FXML
    void addPasswordAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/categoriesToAddPassword.fxml")));
    }

    @FXML
    void exitAction(ActionEvent event) throws Exception {
        System.exit(0);
    }

    @FXML
    void nightModeAction(ActionEvent event) {
//        Image nightHangMan = new Image("images/.png");
//        Image dayHangMan = new Image("images/wisielec.png");
        if(nightModeButton.isSelected()) {
            HangmanDelegate.root.getStylesheets().clear();
            HangmanDelegate.root.getStylesheets().add("stylesheet/nightStyle.css");
//            logoPane.setImage(nightHangMan);
        }
    }

    @FXML
    void dayModeAction(ActionEvent event) {
//        Image nightHangMan = new Image("images/wisielecNoc.png");
//        Image dayHangMan = new Image("images/test.png");
        if(dayModeButton.isSelected()) {
            HangmanDelegate.root.getStylesheets().clear();
            HangmanDelegate.root.getStylesheets().add("stylesheet/dayStyle.css");
//            logoPane.setImage(dayHangMan);
        }
    }
}
