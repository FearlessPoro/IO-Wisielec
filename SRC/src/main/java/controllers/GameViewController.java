package controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import logic.Category;
import logic.Game;
import logic.GameTypes;
import logic.LevelDifficulty;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GameViewController {

    static LevelDifficulty level = LevelDifficulty.EASY;
    static Category category = Category.ALL;
    static GameTypes type = GameTypes.NEW_GAME;
    Timeline labelChange, endCall;



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
    public Pane hangedManPane;

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
    private Button checkPassword, giveUpButton, saveAndExitButton;

    @FXML
    private Label passwordCategory;

    private Alert alert;
    private DialogPane dialog;

    @FXML
    private Label clockLabel;

    //shapes
    private Rectangle gallows1 = new Rectangle(50, 310, 140, 20);
    private Rectangle gallows2 = new Rectangle(100, 20, 20, 300);
    private Rectangle gallows3 = new Rectangle(40, 30, 300, 20);
    private Line gallows4 = new Line(95, 90, 175, 30);
    private Line gallows5 = new Line(245, 35, 245, 90);
    private Ellipse head = new Ellipse(245,120,30,30);
    private Ellipse stomach = new Ellipse(245,195,35,50);

    private Line leftArm = new Line(230, 162, 190, 200);
    private Line rightArm = new Line(300, 200, 260, 162);
    private Line leftLeg = new Line(230, 240, 220, 280);
    private Line rightLeg = new Line(260, 240, 270, 280);

    private Line leftArmJ = new Line(230, 162, 170, 160);
    private Line rightArmJ = new Line(320, 162, 260, 160);
    private Line leftLegJ = new Line(230, 235, 180, 255);
    private Line rightLegJ = new Line(260, 235, 310, 255);

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

    private void initAlert() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Powrót do menu głównego");
        dialog = alert.getDialogPane();

        alert.setOnCloseRequest(event -> {
            try {
                HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
            }
            catch (Exception e){}
        });

        if(HangmanDelegate.nightModeOn)
            dialog.getStylesheets().add("stylesheet/nightStyle.css");
        else
            dialog.getStylesheets().add("stylesheet/dayStyle.css");
    }

    private void showMessageAboutResultAndReturnToMenu(String message){
        alert.setContentText(message);
        alert.getDialogPane().getChildren().stream().filter(node -> node instanceof Label).forEach(node -> ((Label)node).setMinHeight(Region.USE_PREF_SIZE));

        endCall.stop();
        labelChange.stop();

        alert.setOnHidden((event) -> {
          try {
              HangmanDelegate.root.getChildren().add(FXMLLoader.load(getClass().getResource("../fxml/mainView.fxml")));
          }  catch (IOException e)
          {e.printStackTrace();}
        });
        alert.show();
    }


    private void drawGrayHangman(){

        gallows5.setStrokeWidth(10);
        gallows5.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(gallows5);

        gallows4.setStrokeWidth(10);
        gallows4.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(gallows4);

        gallows3.setArcHeight(10);
        gallows3.setArcWidth(10);
        gallows3.setFill(Color.GRAY);
        hangedManPane.getChildren().add(gallows3);

        gallows2.setArcHeight(10);
        gallows2.setArcWidth(10);
        gallows2.setFill(Color.GRAY);
        hangedManPane.getChildren().add(gallows2);

        gallows1.setArcHeight(10);
        gallows1.setArcWidth(10);
        gallows1.setFill(Color.GRAY);
        hangedManPane.getChildren().add(gallows1);

        leftArm.setStrokeWidth(18);
        leftArm.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(leftArm);

        rightArm.setStrokeWidth(18);
        rightArm.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(rightArm);

        leftLeg.setStrokeWidth(18);
        leftLeg.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(leftLeg);

        rightLeg.setStrokeWidth(18);
        rightLeg.setStroke(Color.GRAY);
        hangedManPane.getChildren().add(rightLeg);

        stomach.setFill(Color.GRAY);
        hangedManPane.getChildren().add(stomach);

        head.setFill(Color.GRAY);
        hangedManPane.getChildren().add(head);
    }

    private void drawColourfulHangman(int amountOfLives){

        switch (amountOfLives){
            case 9:     gallows1.setFill(Color.GREEN);
                        break;
            case 8:     gallows2.setFill(Color.GREEN);
                        break;
            case 7:     gallows3.setFill(Color.GREEN);
                        break;
            case 6:     gallows4.setStroke(Color.GREEN);
                        break;
            case 5:     gallows5.setStroke(Color.GREEN);
                        head.setFill(Color.GREEN);
                        break;
            case 4:     stomach.setFill(Color.GREEN);
                        break;
            case 3:     leftArm.setStroke(Color.GREEN);
                        break;
            case 2:     rightArm.setStroke(Color.GREEN);
                        break;
            case 1:     leftLeg.setStroke(Color.GREEN);
                        break;
            case 0:     rightLeg.setStroke(Color.GREEN);
                        break;
            default:
                        break;
        }
    }

    void initTimer()
    {
        clockLabel.setDisable(false);
        int maxSeconds = game.getSecondsLeft();

        labelChange = new Timeline();
        labelChange.setCycleCount(maxSeconds);
        labelChange.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        game.decrementSecondsLeft();
                        clockLabel.setText(String.valueOf(game.getSecondsLeft()));

                    }
                }));

        endCall = new Timeline();
        endCall.getKeyFrames().add(new KeyFrame(Duration.millis(1000 * maxSeconds),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        showMessageAboutResultAndReturnToMenu(game.takeEndMessage());
                    }
                }));
        labelChange.play();
        endCall.play();


    }

    @FXML
    void initialize() {

        game = new Game(level, category, type, GameTypes.timed);

        drawGrayHangman();
        initAlert();

        if (game.deserialize()) {
            System.out.println("Udana deseralizacja");
            guessPasswordField.setFont(Font.font("Verdana", 40));
            guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
            leftChanceLabel.setText(Integer.toString(game.getHearths()));
            for(int i=9; i>=game.getHearths(); i--) {
                drawColourfulHangman(i);
            }
            changeButtonsState(true);
            changeButtonStateAfterDeserialization(false);
        } else {

            game.start();

            guessPasswordField.setFont(Font.font("Verdana", 40));
            guessPasswordField.setText(String.valueOf(game.getUnknownWord()));
            leftChanceLabel.setText(Integer.toString(game.getHearths()));
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
            case NATURE:    passwordCategory.setText("Natura");
                            break;
            default:        passwordCategory.setText("Błąd");
                            break;
        }

        assert keyboardPane != null : "fx:id=\"keyboardPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert passwordPane != null : "fx:id=\"passwordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert guessPasswordField != null : "fx:id=\"guessPasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert wholePasswordField != null : "fx:id=\"wholePasswordField\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert hangedManPane != null : "fx:id=\"hangedManPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert winMessageLabel != null : "fx:id=\"winMessageLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert leftChanceLabel != null : "fx:id=\"leftChanceLabel\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";
        assert buttonsPane != null : "fx:id=\"randomPasswordPane\" was not injected: check your FXML file 'controllers.Gui1.fxml'.";

        if(GameTypes.timed)
        {
            saveAndExitButton.setDisable(true);
            initTimer();
        } else {
            saveAndExitButton.setDisable(false);
        }
    }

    @FXML
    void jumpingJackClicked(MouseEvent event){

        List<Line> lines = new ArrayList<>();
        leftArm.setStrokeWidth(18);
        lines.add(leftArm);
        rightArm.setStrokeWidth(18);
        lines.add(rightArm);
        leftLeg.setStrokeWidth(18);
        lines.add(leftLeg);
        rightLeg.setStrokeWidth(18);
        lines.add(rightLeg);

        List<Line> JumpingLines = new ArrayList<>();
        leftArmJ.setStrokeWidth(18);
        leftArmJ.setStroke(leftArm.getStroke());
        JumpingLines.add(leftArmJ);
        rightArmJ.setStrokeWidth(18);
        rightArmJ.setStroke(rightArm.getStroke());
        JumpingLines.add(rightArmJ);
        leftLegJ.setStrokeWidth(18);
        leftLegJ.setStroke(leftLeg.getStroke());
        JumpingLines.add(leftLegJ);
        rightLegJ.setStrokeWidth(18);
        rightLegJ.setStroke(rightLeg.getStroke());
        JumpingLines.add(rightLegJ);

        Timeline timeline = new Timeline();
        Duration timepoint = Duration.ZERO;
        Duration pause = Duration.millis(500);

        KeyFrame keyFrameStomachRem;
        KeyFrame keyFrameStomachAdd;

        timepoint = timepoint.add(pause);

        for (Line line : lines) {
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> hangedManPane.getChildren().remove(line));
            timeline.getKeyFrames().add(keyFrame);
        }

        for (Line line : JumpingLines) {
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> hangedManPane.getChildren().add(line));
            timeline.getKeyFrames().add(keyFrame);
        }

        keyFrameStomachRem = new KeyFrame(timepoint, e -> hangedManPane.getChildren().remove(stomach));
        timeline.getKeyFrames().add(keyFrameStomachRem);
        keyFrameStomachAdd = new KeyFrame(timepoint, e -> hangedManPane.getChildren().add(stomach));
        timeline.getKeyFrames().add(keyFrameStomachAdd);

        timepoint = timepoint.add(pause);

        for (Line line : JumpingLines) {
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> hangedManPane.getChildren().remove(line));
            timeline.getKeyFrames().add(keyFrame);
        }

        for (Line line : lines) {
            KeyFrame keyFrame = new KeyFrame(timepoint, e -> hangedManPane.getChildren().add(line));
            timeline.getKeyFrames().add(keyFrame);
        }
        keyFrameStomachRem = new KeyFrame(timepoint, e -> hangedManPane.getChildren().remove(stomach));
        timeline.getKeyFrames().add(keyFrameStomachRem);
        keyFrameStomachAdd = new KeyFrame(timepoint, e -> hangedManPane.getChildren().add(stomach));
        timeline.getKeyFrames().add(keyFrameStomachAdd);

        timeline.play();
    }

    @FXML
    void checkPasswordAction(ActionEvent event) {
        String wholePassword = wholePasswordField.getText();

        if (game.checkWholeWord(wholePassword)) {
            //changeButtonsState(false);
            showMessageAboutResultAndReturnToMenu(game.takeEndMessage());
        } else {
            game.setLivesToZero();
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
        //not necessary i think
        /*if (game.getType().equals(GameTypes.RESTORED_GAME)) {
            game.clearSaves();
        }*/
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
            changeButtonsState(false);
            for(int i=0; i<=9; i++){
                drawColourfulHangman(i);
            }
            showMessageAboutResultAndReturnToMenu(game.takeEndMessage());
        }
    }

    private void changeButtonsState(Boolean state) {
        for (Node node : keyboardPane.getChildren()) {
            if (node instanceof Button) {
                node.setDisable(!state);
            }
        }
        checkPassword.setDisable(!state);
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
