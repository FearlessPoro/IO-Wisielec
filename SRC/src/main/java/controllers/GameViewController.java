package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.Category;
import logic.Game;
import logic.LevelDifficulty;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController {

    static LevelDifficulty level = LevelDifficulty.EASY;
    static Category category = Category.ALL;

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
    private Pane buttonsPane;

    @FXML
    private Label passwordCategoryLabel;

    @FXML
    private Button A, A1, B, C, C1, D, E, E1, F, G, H, I, J, K, L, L1, M, N, N1, O, O1, P, Q, R, S, S1, T, U, V, W, X, Y, Z, Z1, Z2;

    @FXML
    private Button checkPassword, randomPassword, giveUpButton;

    @FXML
    public Canvas hangmanCanvas;

    @FXML
    public Label passwordCategory;

    @FXML
    private Button jumpingJackButton;

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

    public void drawGrayHangman(boolean jumping){

        GraphicsContext gc = hangmanCanvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.setStroke(Color.GRAY);

        //gallows tree
        gc.fillRoundRect(50, 310, 140, 20, 10, 10);
        gc.fillRoundRect(100, 20, 20, 300, 10, 10);
        gc.fillRoundRect(40, 30, 300, 20, 10, 10);
        gc.setLineWidth(10);
        gc.strokeLine(95, 90, 175, 30);
        gc.setLineWidth(8);
        gc.strokeLine(245, 35, 245, 90);

        if(!jumping) {
            //arms
            gc.setLineWidth(18);
            gc.strokeLine(230, 162, 190, 200);
            gc.strokeLine(300, 200, 260, 162);

            //legs
            gc.strokeLine(230, 240, 220, 280);
            gc.strokeLine(260, 240, 270, 280);
        }
        else {
            gc.setLineWidth(18);
            gc.strokeLine(220, 150, 190, 200);
            gc.strokeLine(320, 190, 260, 162);

            //legs
            gc.strokeLine(230, 240, 220, 280);
            gc.strokeLine(260, 240, 270, 280);
        }

        //stomach
        gc.fillOval(210,145,70,100);

        //head
        gc.fillOval(215,90,60,60);
    }

    public void drawColourfulHangman(int amountOfLives){
        GraphicsContext gc = hangmanCanvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
        switch (amountOfLives){
            case 9:     gc.fillRoundRect(50, 310, 140, 20, 10, 10);
                break;
            case 8:     gc.fillRoundRect(100, 20, 20, 300, 10, 10);
                break;
            case 7:     gc.fillRoundRect(40, 30, 300, 20, 10, 10);
                gc.setLineWidth(10);
                gc.strokeLine(95, 90, 175, 30);
                break;
            case 6:     gc.setLineWidth(10);
                gc.strokeLine(245, 35, 245, 90);
                break;
            case 5:     gc.fillOval(215,90,60,60);
                break;
            case 4:     gc.fillOval(210,145,70,100);
                break;
            case 3:     gc.setLineWidth(18);
                gc.strokeLine(230, 162, 190, 200);
                break;
            case 2:     gc.setLineWidth(18);
                gc.strokeLine(300, 200, 260, 162);
                break;
            case 1:     gc.setLineWidth(18);
                gc.strokeLine(230, 240, 220, 280);
                break;
            case 0:     gc.setLineWidth(18);
                gc.strokeLine(260, 240, 270, 280);
                break;
            default:
                break;
        }
    }



    @FXML
    void initialize() {

        changeButtonsState(false);
        game = new Game(level, category);

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

        switch (category){
            case ALL:       passwordCategory.setText("Wszystkie");
                            break;
            case KINO:      passwordCategory.setText("Kino");
                            break;
            case MUSIC:     passwordCategory.setText("Muzyka");
                            break;
            case CULINARY:  passwordCategory.setText("Kulinaria");
                            break;
            case GEOGRAPHY: passwordCategory.setText("Geografia");
                            break;
            case SPORT:     passwordCategory.setText("Sport");
                            break;
            case LITERATURE:passwordCategory.setText("Literatura");
                            break;
            default:        passwordCategory.setText("Błąd");
                            break;
        }

        drawGrayHangman(false);

        assert keyboardPane != null : "fx:id=\"keyboardPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert passwordPane != null : "fx:id=\"passwordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert guessPasswordField != null : "fx:id=\"guessPasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert wholePasswordField != null : "fx:id=\"wholePasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert hangedManPane != null : "fx:id=\"hangedManPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert winMessageLabel != null : "fx:id=\"winMessageLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert leftChanceLabel != null : "fx:id=\"leftChanceLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert buttonsPane != null : "fx:id=\"randomPasswordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
    }

    @FXML
    void jumpingJackAction(ActionEvent event) {
//
//        GraphicsContext gc = hangmanCanvas.getGraphicsContext2D();
//        gc.clearRect(0, 0, hangmanCanvas.getWidth(), hangmanCanvas.getHeight());
//        for(int i=10; i==game.getHearths(); i--){
//            drawColourfulHangman(i);
//        }
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

    @FXML
    void giveUpAction(ActionEvent event) throws Exception{
        HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
    }

    private void afterClickedOnLetter(Character character) {
        game.selectedLetter(character);
        checkIfContinue();
        drawColourfulHangman(game.getHearths());
    }

    private void checkIfContinue() {
        guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
        leftChanceLabel.setText(Integer.toString(game.getHearths()));

        if (!game.canPlay()) {
            guessPasswordField.setFont(Font.font("Verdana", 20));
            guessPasswordField.setText(String.valueOf(game.takeEndMessage()));
            changeButtonsState(false);
            drawColourfulHangman(game.getHearths());
        }
    }

    private void changeButtonsState(Boolean state) {
        for (Node node : keyboardPane.getChildren()) {
            if (node instanceof Button) {
                node.setDisable(!state);
            }
        }
        checkPassword.setDisable(!state);
        randomPassword.setDisable(state);
    }

    private void changeButtonStateAfterDeserialization(Boolean state) {
        for (Node node : keyboardPane.getChildren()) {
            if (node instanceof Button) {
                final Button button = (Button) node;
                if (game.alreadySelectedLetter(button.getText().charAt(0))) {
                    button.setDisable(!state);
                }
            }
        }
    }

}
