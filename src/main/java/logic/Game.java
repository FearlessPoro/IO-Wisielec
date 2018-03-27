package logic;

import dao.CsvDao;
import entity.HangManEntity;
import entity.WordEntity;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private WordEntity wordEntity;

    private void randomiseWord(){
        CsvDao csvDao;
        try {
            Path path = Paths.get("src/test/resources", "sample.csv");
            Reader reader = Files.newBufferedReader(
                    path, Charset.forName("UTF-8"));
            csvDao = new CsvDao(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        List<List<String>> allWords = csvDao.readRecords();
        Random randomizer = new Random();
        List<String> wordToGuess = allWords.get(randomizer.nextInt(allWords.size()));

        this.wordEntity = new WordEntity(String.join(" ", wordToGuess));
    }

    public void start(){
        randomiseWord();
        HangManEntity hangManEntity = new HangManEntity();

        char selectedLetter;
        while(hangManEntity.getHearths() > 0 && (!wordEntity.allLettersReveal())){
            System.out.println("Word to guess: " + String.valueOf(wordEntity.getUnknownWord()) +
                    ". You have " + hangManEntity.getHearths() + " lives." );

            System.out.print("Choose some letter: ");
            Scanner reader = new Scanner(System.in);
            selectedLetter = reader.next().charAt(0);

            if(wordEntity.alreadySelectedLetter(selectedLetter)){
                System.out.println("You tried with \'" + selectedLetter + "\' letter before");
                hangManEntity.decrementLives();
                continue;
            }else{
                wordEntity.addToAlreadySelectedLetter(selectedLetter);
            }

            if(wordEntity.ifWordToGuessContainsLetter(selectedLetter)){
                System.out.println("You chosen good letter. \'" + selectedLetter + "\' is in the word.");
            }else{
                System.out.println("You chosen bad letter. \'" + selectedLetter + "\' is not in the word.");
                hangManEntity.decrementLives();
            }

            if(wordEntity.allLettersReveal())
                break;
        }

        if(hangManEntity.getHearths() > 0){
            System.out.println("Congratulations! You win and you still have " + hangManEntity.getHearths() + " more lives.");
        }else{
            System.out.println("No more lives. You lose!" );
            System.out.println("The word to guess was: \"" + wordEntity.getWordToGuess() + "\".");
        }
    }
}
