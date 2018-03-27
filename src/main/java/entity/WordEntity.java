package entity;

import java.util.Arrays;

public class WordEntity {

    private String wordToGuess;
    private char[] unknownWord;

    public WordEntity(String wordToGuess) {
        this.wordToGuess = wordToGuess;

        unknownWord = new char[wordToGuess.length()];
        Arrays.fill(unknownWord, '_');
    }

    public void revealLetter(int index) {
        unknownWord[index] = wordToGuess.charAt(index);
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public char[] getUnknownWord() {
        return unknownWord;
    }
}
