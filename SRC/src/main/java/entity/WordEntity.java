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
        char lowerCaseCharacter = character.toString().toLowerCase().charAt(0);
        return selectedLetters.contains(lowerCaseCharacter);
    }

    public void addToAlreadySelectedLetter(Character character) {
        char lowerCaseCharacter = character.toString().toLowerCase().charAt(0);
        selectedLetters.add(lowerCaseCharacter);
    }

    public boolean doesTheWordToGuessContainsLetter(char character) {
        String charToCompareLowerCase = String.valueOf(character).toLowerCase();
        return wordToGuess.toLowerCase().contains(charToCompareLowerCase);
    }

    public void revealAllDuplicatesIfWordToGuessContainsLetter(char character) {
        char lowerCaseCharacter = String.valueOf(character).toLowerCase().charAt(0);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.toLowerCase().charAt(i) == lowerCaseCharacter) {
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
