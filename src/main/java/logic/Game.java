package logic;

import dao.CsvDao;
import entity.HangManEntity;
import entity.WordEntity;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Game {
    private WordEntity wordEntity;
    private HangManEntity hangManEntity;

    public void start() {
        gameInit();

        while (canPlay(wordEntity, hangManEntity)) {
            continueGameStep();
        }

        showWinLossMessages(wordEntity, hangManEntity);
    }

    private void gameInit() {
        Path path = Paths.get("src/main/resources", "sample.csv");
        wordEntity = new CsvDao(path).getRandomWord();
        hangManEntity = new HangManEntity();
    }

    private boolean canPlay(WordEntity wordEntity, HangManEntity hangManEntity) {
        return hangManEntity.isAlive() && !wordEntity.allLettersRevealed();
    }

    private void continueGameStep() {
        System.out.println("Word to guess: " + String.valueOf(wordEntity.getUnknownWord()) +
                ". You have " + hangManEntity.getHearths() + " lives.");

        char selectedLetter = selectLetter();

        if (wordEntity.alreadySelectedLetter(selectedLetter)) {
            System.out.println("You tried with \'" + selectedLetter + "\' letter before");
            hangManEntity.decrementLives();
            return;
        } else {
            wordEntity.addToAlreadySelectedLetter(selectedLetter);
        }

        if (wordEntity.doesTheWordToGuessContainsLetter(selectedLetter)) {
            wordEntity.revealAllDuplicatesIfWordToGuessContainsLetter(selectedLetter);
            System.out.println("You've chosen good letter. \'" + selectedLetter + "\' is in the word.");
        } else {
            System.out.println("You've chosen bad letter. \'" + selectedLetter + "\' is not in the word.");
            hangManEntity.decrementLives();
        }
    }

    private char selectLetter() {
        System.out.print("Choose some letter: ");
        Scanner reader = new Scanner(System.in);

        return reader.next().charAt(0);
    }

    private void showWinLossMessages(WordEntity wordEntity, HangManEntity hangManEntity) {
        if (hangManEntity.isAlive()) {
            System.out.println("Congratulations! You win and you still have " + hangManEntity.getHearths() + " more lives.");
        } else {
            System.out.println("No more lives. You lose!");
            System.out.println("The word to guess was: \"" + wordEntity.getWordToGuess() + "\".");
        }
    }
}
