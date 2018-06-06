package controllers;

import dao.CsvDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import logic.Category;

import java.io.IOException;
import java.util.Optional;

public class AddPasswordController {

    static Category category = Category.ALL;

    private CsvDao csvDao;

    @FXML
    private TextArea passwordToAddTextArea;

    @FXML
    private TextArea passwordToConfirmTextArea;

    @FXML
    private Button confirmButton;

    @FXML
    private Label confirmationLabel;

    @FXML
    private Button returnButton;

    private Alert alert;



    @FXML
    void confirmAction(ActionEvent event) throws Exception{
        csvDao = new CsvDao("sample.csv", category);
        String message;

        message = csvDao.canAdd(passwordToAddTextArea.getText(), passwordToConfirmTextArea.getText());

        alert.setContentText(message);
        alert.getDialogPane().getChildren().stream().filter(node -> node instanceof Label).forEach(node -> ((Label)node).setMinHeight(Region.USE_PREF_SIZE));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            alert.close();
        }
    }

    @FXML
    void returnAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }

    private void initAlert() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("OK");
    }

    @FXML
    void initialize() {
    initAlert();

    assert passwordToAddTextArea != null : "fx:id=\"passwordToAddTextArea\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
    assert passwordToConfirmTextArea != null : "fx:id=\"passwordToConfirmTextArea\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";

    }
}