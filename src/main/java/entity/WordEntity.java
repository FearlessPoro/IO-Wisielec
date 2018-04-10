package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordEntity implements Serializable {

    private String wordToGuess;
    private char[] unknownWord;
    private List<Character> selectedLetters;

    public WordEntity(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.unknownWord = new char[wordToGuess.length()];
        this.selectedLetters = new ArrayList<>();

        for (int i = 0; i < wordToGuess.length(); ++i) {
            if (Character.isWhitespace(wordToGuess.charAt(i)))
                unknownWord[i] = ' ';
            else
                unknownWord[i] = '_';
        }
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public char[] getUnknownWord() {
        return unknownWord;
    }

    public boolean alreadySelectedLetter(Character character) {
        return selectedLetters.contains(character);
    }

    public void addToAlreadySelectedLetter(Character character) {
        selectedLetters.add(character);
    }

    public boolean doesTheWordToGuessContainsLetter(char character) {
        return wordToGuess.contains(String.valueOf(character));
    }

    public void revealAllDuplicatesIfWordToGuessContainsLetter(char character) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == character) {
                revealLetter(i);
            }
        }
    }

    public boolean allLettersRevealed() {
        return !Arrays.toString(unknownWord).contains("_");
    }

    private void revealLetter(int index) {
        unknownWord[index] = wordToGuess.charAt(index);
    }
}
