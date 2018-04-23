package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class CategoriesContoller {

    @FXML
    private Pane categoriesPane;

    @FXML
    private Button allChooseButton;

    @FXML
    private Button musicChooseButton;

    @FXML
    private Button sportChooseButton;

    @FXML
    private Button geographyChooseButton;

    @FXML
    private Button kinoChooseButton;

    @FXML
    private Button culinaryChooseButton;

    @FXML
    private Button returnButton;

    @FXML
    void allChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void culinaryChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void geographyChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void kinoChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void literatureChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void musicChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void sportChooseAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/gameView.fxml")));
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception {
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../mainView.fxml")));
    }
}
