package logic;

import dao.CsvDao;
import entity.HangManEntity;
import entity.RankEntity;
import entity.WordEntity;

import java.io.*;
import java.net.URL;

public class Game {
    private WordEntity wordEntity;
    private HangManEntity hangManEntity;
    private boolean inGame = false;
    private LevelDifficulty level;
    private Category category;
    private GameTypes type;
    private int secondsLeft = 60;
    private boolean timedGame;

    public static void setRank(RankEntity rank) {
        Game.rank = rank;
    }

    public GameTypes getType() {
        return type;
    }

    private static RankEntity rank;

    public void setLivesToZero() { hangManEntity.setLivesToZero(); }

    public void decrementSecondsLeft(){ secondsLeft--; }

    public int getSecondsLeft(){ return secondsLeft; }

    public Game(LevelDifficulty level, Category category, GameTypes type, boolean timed) {
        this.level = level;
        this.category = category;
        this.type = type;
        this.timedGame = timed;
        SoundEffect.init();
    }

    public void start() {
        inGame = true;
        wordEntity = new CsvDao("sample.csv", category, level).getRandomWord();
        hangManEntity = new HangManEntity();
    }


    public boolean checkIfInGame() {
        return inGame;
    }

    public char[] getUnknownWord() {
        return wordEntity.getUnknownWord();
    }

    public String getWordToGuess() {
        return wordEntity.getWordToGuess();
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
        if(secondsLeft <= 0) {
            SoundEffect.GAME_LOST.play();
            return "Czas się skończył! Przegrywasz! " + "\nSłowo do odgadnięcia: \"" + wordEntity.getWordToGuess() + "\".";
        }else {
            if (hangManEntity.isAlive()) {
                SoundEffect.GAME_WON.play();
                rank.addToRank(calculatePoints(), wordEntity.getWordToGuess());
                RankEntity.serialize(rank);
                if (type == GameTypes.RESTORED_GAME) {
                    clearSaves();
                }
                return "Gratulacje! Słowo do odgadnięcia: " + wordEntity.getWordToGuess() + ".\nWygrałeś oraz masz wciąż " + hangManEntity.getHearths() + " żyć.";
            }else {
                SoundEffect.GAME_LOST.play();
                return "Straciłeś wszystkie życia. Przegrywasz! " + "\nSłowo do odgadnięcia: \"" + wordEntity.getWordToGuess() + "\".";
            }
        }

    }

    private int calculatePoints() {
        return level.getPoints() + secondsLeft + 10 * hangManEntity.getHearths();
    }

    public boolean checkWholeWord(String wholeWord) {
        if (wholeWord.equalsIgnoreCase(wordEntity.getWordToGuess())) {
            inGame = false;
            return true;
        } else {
            hangManEntity.decrementLives();
            return false;
        }
    }

    public void serialize() {




        String dir = Game.class.getResource("/").getFile();
        try (FileOutputStream fileOut = new FileOutputStream(dir + "/game.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(wordEntity);
            out.writeObject(hangManEntity);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public boolean deserialize() {
        URL url = RankEntity.class.getResource("/game.ser");
        String dir = url != null ? url.getFile() : "";
        File f = new File(dir);

        if (f.exists() && !f.isDirectory() && type == GameTypes.RESTORED_GAME) {
            try (FileInputStream fileIn = new FileInputStream(dir);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
                wordEntity = (WordEntity) in.readObject();
                hangManEntity = (HangManEntity) in.readObject();
                fileIn.close();
                in.close();
                inGame = true;
                clearSaves();

                return true;
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }

        return false;
    }

    public void clearSaves() {
        URL url = RankEntity.class.getResource("/game.ser");
        String dir = url != null ? url.getFile() : "";
        File f = new File(dir);
        if (f.exists() && !f.isDirectory()) {
            if (f.delete()) {
                System.out.println("Usunieto save");
            }
        }
    }

    public static String getRankEntity() {
        return rank.toString();
    }


}
