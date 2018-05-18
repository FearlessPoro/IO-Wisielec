package logic;

import dao.CsvDao;
import entity.HangManEntity;
import entity.RankEntity;
import entity.WordEntity;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Game {
    private WordEntity wordEntity;
    private HangManEntity hangManEntity;
    private boolean inGame = false;
    private LevelDifficulty level;
    private Category category;
    private int secondsLeft = 0;
    private RankEntity rank;

    public Game(LevelDifficulty level, Category category) {
        this.level = level;
        this.category = category;

        SoundEffect.init();
    }

    public void start() {
        inGame = true;
        Path path = Paths.get("src/main/resources", "database/sample.csv");
        wordEntity = new CsvDao(path).getRandomWord();
        hangManEntity = new HangManEntity();

        rank = RankEntity.deserialize();
    }

    public boolean checkIfInGame() {
        return inGame;
    }

    public char[] getUnknownWord() {
        return wordEntity.getUnknownWord();
    }

    public int getHearths() {
        return hangManEntity.getHearths();
    }

    public boolean alreadySelectedLetter(Character character) {
        return wordEntity.alreadySelectedLetter(character);
    }

    public void selectedLetter(Character character) {
        if (wordEntity.alreadySelectedLetter(character)) {
            hangManEntity.decrementLives();
            SoundEffect.BAD_LETTER.play();
            return;
        } else {
            wordEntity.addToAlreadySelectedLetter(character);
            SoundEffect.GOOD_LETTER.play();
        }

        if (wordEntity.doesTheWordToGuessContainsLetter(character)) {
            wordEntity.revealAllDuplicatesIfWordToGuessContainsLetter(character);
        } else {
            hangManEntity.decrementLives();
            SoundEffect.BAD_LETTER.play();
        }
    }

    public boolean canPlay() {
        return inGame = (hangManEntity.isAlive() && !wordEntity.allLettersRevealed());
    }

    public String takeEndMessage() {
        if (hangManEntity.isAlive()) {
            SoundEffect.GAME_WON.play();
            rank.addToRank(calculatePoints(), wordEntity.getWordToGuess());
            RankEntity.serialize(rank);
            return "Congratulations! Guessed word: " + wordEntity.getWordToGuess() + ". You win and you still have " + hangManEntity.getHearths() + " more lives.";
        } else {
            SoundEffect.GAME_LOST.play();
            return "No more lives. You lose!" + "The word to guess was: \"" + wordEntity.getWordToGuess() + "\".";
        }
    }

    private int calculatePoints() {
        return level.getPoints() + secondsLeft + 10 * hangManEntity.getHearths();
    }

    public boolean checkWholeWord(String wholeWord) {
        if (wholeWord.equals(wordEntity.getWordToGuess())) {
            inGame = false;
            return true;
        } else {
            hangManEntity.setLivesToZero();
            return false;
        }
    }

    public void serialize() {
        try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/game.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(wordEntity);
            out.writeObject(hangManEntity);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public boolean deserialize() {
        File f = new File("src/main/resources/game.ser");

        if (f.exists() && !f.isDirectory()) {
            try (FileInputStream fileIn = new FileInputStream("src/main/resources/game.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                wordEntity = (WordEntity) in.readObject();
                hangManEntity = (HangManEntity) in.readObject();

                inGame = true;
                clearSaves();

                return true;
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }

        return false;
    }

    private void clearSaves() {
        File f = new File("src/main/resources/game.ser");
        if (f.exists() && !f.isDirectory()) {
            if (f.delete()) {
                System.out.println("Usunieto save");
            }
        }
    }

}