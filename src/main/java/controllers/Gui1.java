package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class Gui1 {

    private Game game;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane keyboardPane;

    @FXML
    private Pane passwordPane;

    @FXML
    private TextArea guessPasswordField;

    @FXML
    private TextArea wholePasswordField;

    @FXML
    private Pane hangedManPane;

    @FXML
    private Label winMessageLabel;

    @FXML
    private Label leftChanceLabel;

    @FXML
    private Pane randomPasswordPane;

    @FXML
    private Pane saveAndExitPane;

    @FXML
    private Button A, A1, B, C, C1, D, E, E1, F, G, H, I, J ,K, L, L1, M, N, N1, O, O1, P, Q, R, S, S1, T, U, V, W, X, Y ,Z, Z1, Z2 ;

    @FXML
    private Button checkPassword, randomPassword;

    @FXML
    void a1Click(ActionEvent event) {
        afterClickedOnLetter('Ą');
        A1.setDisable(true);
    }

    @FXML
    void aClick(ActionEvent event) {
        afterClickedOnLetter('A');
        A.setDisable(true);
    }

    @FXML
    void bClick(ActionEvent event) {
        afterClickedOnLetter('B');
        B.setDisable(true);
    }

    @FXML
    void c1Click(ActionEvent event) {
        afterClickedOnLetter('Ć');
        C1.setDisable(true);
    }

    @FXML
    void cClick(ActionEvent event) {
        afterClickedOnLetter('C');
        C.setDisable(true);
    }


    @FXML
    void dClick(ActionEvent event) {
        afterClickedOnLetter('D');
        D.setDisable(true);
    }

    @FXML
    void e1Click(ActionEvent event) {
        afterClickedOnLetter('Ę');
        E1.setDisable(true);
    }

    @FXML
    void eClick(ActionEvent event) {
        afterClickedOnLetter('E');
        E.setDisable(true);
    }

    @FXML
    void fClick(ActionEvent event) {
        afterClickedOnLetter('F');
        F.setDisable(true);
    }

    @FXML
    void gClick(ActionEvent event) {
        afterClickedOnLetter('G');
        G.setDisable(true);
    }

    @FXML
    void hClick(ActionEvent event) {
        afterClickedOnLetter('H');
        H.setDisable(true);
    }

    @FXML
    void iClick(ActionEvent event) {
        afterClickedOnLetter('I');
        I.setDisable(true);
    }

    @FXML
    void jClick(ActionEvent event) {
        afterClickedOnLetter('J');
        J.setDisable(true);
    }

    @FXML
    void kClick(ActionEvent event) {
        afterClickedOnLetter('K');
        K.setDisable(true);
    }

    @FXML
    void l1Click(ActionEvent event) {
        afterClickedOnLetter('Ł');
        L1.setDisable(true);
    }

    @FXML
    void lClick(ActionEvent event) {
        afterClickedOnLetter('L');
        L.setDisable(true);
    }

    @FXML
    void mClick(ActionEvent event) {
        afterClickedOnLetter('M');
        M.setDisable(true);
    }

    @FXML
    void n1Click(ActionEvent event) {
        afterClickedOnLetter('Ń');
        N1.setDisable(true);
    }

    @FXML
    void nClick(ActionEvent event) {
        afterClickedOnLetter('N');
        N.setDisable(true);
    }

    @FXML
    void o1Click(ActionEvent event) {
        afterClickedOnLetter('Ó');
        O1.setDisable(true);
    }

    @FXML
    void oClick(ActionEvent event) {
        afterClickedOnLetter('O');
        O.setDisable(true);
    }

    @FXML
    void pClick(ActionEvent event) {
        afterClickedOnLetter('P');
        P.setDisable(true);
    }

    @FXML
    void qClick(ActionEvent event) {
        afterClickedOnLetter('Q');
        Q.setDisable(true);
    }

    @FXML
    void rClick(ActionEvent event) {
        afterClickedOnLetter('R');
        R.setDisable(true);
    }

    @FXML
    void s1Click(ActionEvent event) {
        afterClickedOnLetter('Ś');
        S1.setDisable(true);
    }

    @FXML
    void sClick(ActionEvent event) {
        afterClickedOnLetter('S');
        S.setDisable(true);
    }

    @FXML
    void tClick(ActionEvent event) {
        afterClickedOnLetter('T');
        T.setDisable(true);
    }

    @FXML
    void uClick(ActionEvent event) {
        afterClickedOnLetter('U');
        U.setDisable(true);
    }

    @FXML
    void vClick(ActionEvent event) {
        afterClickedOnLetter('V');
        V.setDisable(true);
    }

    @FXML
    void wClick(ActionEvent event) {
        afterClickedOnLetter('W');
        W.setDisable(true);
    }

    @FXML
    void xClick(ActionEvent event) {
        afterClickedOnLetter('X');
        X.setDisable(true);
    }

    @FXML
    void yClick(ActionEvent event) {
        afterClickedOnLetter('Y');
        Y.setDisable(true);
    }

    @FXML
    void z1Click(ActionEvent event) {
        afterClickedOnLetter('Ź');
        Z1.setDisable(true);
    }

    @FXML
    void z2Click(ActionEvent event) {
        afterClickedOnLetter('Ż');
        Z2.setDisable(true);
    }

    @FXML
    void zClick(ActionEvent event) {
        afterClickedOnLetter('Z');
        Z.setDisable(true);
    }

    @FXML
    void initialize() {

        changeButtonsState(false);
        game = new Game();

        if (game.deserialize()) {
            System.out.println("Udana deseralizacja");
            guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
            leftChanceLabel.setText(Integer.toString(game.getHearths()));
            changeButtonsState(true);
            changeButtonStateAfterDeserialization(false);
        } else {
            changeButtonsState(false);
            System.out.println("Nic do deserializacji");
        }

        assert keyboardPane != null : "fx:id=\"keyboardPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert passwordPane != null : "fx:id=\"passwordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert guessPasswordField != null : "fx:id=\"guessPasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert wholePasswordField != null : "fx:id=\"wholePasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert hangedManPane != null : "fx:id=\"hangedManPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert winMessageLabel != null : "fx:id=\"winMessageLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert leftChanceLabel != null : "fx:id=\"leftChanceLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert randomPasswordPane != null : "fx:id=\"randomPasswordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert saveAndExitPane != null : "fx:id=\"saveAndExitPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
    }

    @FXML
    void randomPasswordAction(ActionEvent event) {
        changeButtonsState(true);

        game.start();

        guessPasswordField.setFont(Font.font("Verdana", 40));
        guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
        leftChanceLabel.setText(Integer.toString(game.getHearths()));
    }

    @FXML
    void checkPasswordAction(ActionEvent event) {
        String wholePassword = wholePasswordField.getText();
        if (game.checkWholeWord(wholePassword)) {
            guessPasswordField.setFont(Font.font("Verdana", 20));
            guessPasswordField.setText(String.valueOf(game.takeEndMessage()));
            changeButtonsState(false);
        } else {
            checkIfContinue();
        }
    }

    @FXML
    void saveAndExitAction(ActionEvent event) {
        if (game.checkIfInGame()) {
            System.out.println("Serializuje");
            game.serialize();
            System.out.println("Po serializacji");
        } else {
            System.out.println("Nic do serializacji");
        }

        System.exit(0);
    }

    private void afterClickedOnLetter(Character character) {
        game.selectedLetter(character);
        checkIfContinue();
    }

    private void checkIfContinue() {
        guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
        leftChanceLabel.setText(Integer.toString(game.getHearths()));

        if(!game.canPlay()) {
            guessPasswordField.setFont(Font.font("Verdana", 20));
            guessPasswordField.setText(String.valueOf(game.takeEndMessage()));
            changeButtonsState(false);
        }
    }

    private void changeButtonsState(Boolean state) {
        for (Node node: keyboardPane.getChildren()) {
            if (node instanceof Button) {
                node.setDisable(!state);
            }
        }
        checkPassword.setDisable(!state);
        randomPassword.setDisable(state);
    }

    private void changeButtonStateAfterDeserialization(Boolean state) {
        for (Node node: keyboardPane.getChildren()) {
            if (node instanceof Button) {
                final Button button = (Button) node;
                if (game.alreadySelectedLetter(button.getText().charAt(0))) {
                    button.setDisable(!state);
                }
            }
        }
    }

}
