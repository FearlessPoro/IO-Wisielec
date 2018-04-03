package entity;

import java.util.ArrayList;

public class WordEntity {

    private String wordToGuess;
    private char[] unknownWord;
    private ArrayList<Character> selectedLetters;

    public WordEntity(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.unknownWord = new char[wordToGuess.length()];
        this.selectedLetters = new ArrayList<>();
        for(int i = 0; i < wordToGuess.length(); ++i) {
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


    public boolean alreadySelectedLetter(Character character){
        return selectedLetters.contains(character);
    }

    public void addToAlreadySelectedLetter(Character character){
        selectedLetters.add(character);
    }

    public boolean ifWordToGuessContainsLetter(char character){
        boolean contains = false;
        for(int i = 0, n = this.wordToGuess.length() ; i < n ; i++) {
            char c = this.wordToGuess.charAt(i);
            if(c == character){
                revealLetter(i);
                contains = true;
            }
        }
        return contains;
    }

    public boolean allLettersRevealed() {
        for(char c : unknownWord)
            if(c == '_')
                return false;
        return true;
    }

    private void revealLetter(int index) {
        unknownWord[index] = wordToGuess.charAt(index);
    }

}
