package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WordEntityTest {
    private WordEntity testEntity;
    private final String testWord = "test";
    private String testUnknownWord = "____";
    private ArrayList<Character> selectedLetters;

    @Before
    public void setUp(){
        testEntity = new WordEntity(testWord);
    }

    @Test
    public void revealLetter() {
        String revealedLetter = "t__t";

        testEntity.ifWordToGuessContainsLetter('t');
        char resultWord[] = testEntity.getUnknownWord();
        Assert.assertArrayEquals(revealedLetter.toCharArray(), resultWord);
    }

    @Test
    public void getWordToGuess() {
        String resultWord = testEntity.getWordToGuess();

        Assert.assertEquals(testWord, resultWord);
    }

    @Test
    public void getUnknownWord() {
        char resultWord[] = testEntity.getUnknownWord();

        Assert.assertArrayEquals(testUnknownWord.toCharArray(), resultWord);
    }

    @Test
    public void addToAlreadySelectedLetter() {
        testEntity.addToAlreadySelectedLetter('t');

        Assert.assertTrue(testEntity.alreadySelectedLetter('t'));
    }

    @Test
    public void alreadySelectedLetter() {
        testEntity.addToAlreadySelectedLetter('e');

        Assert.assertTrue(testEntity.alreadySelectedLetter('e'));
        Assert.assertTrue(!testEntity.alreadySelectedLetter('t'));
    }

    @Test
    public void allLettersRevealed() {
        testEntity.ifWordToGuessContainsLetter('t');
        testEntity.ifWordToGuessContainsLetter('e');
        Assert.assertTrue(!testEntity.allLettersRevealed());

        testEntity.ifWordToGuessContainsLetter('s');
        Assert.assertTrue(testEntity.allLettersRevealed());
    }

    @Test
    public void ifWordToGuessContainsLetter() {
        Assert.assertTrue(testEntity.ifWordToGuessContainsLetter('t'));
        Assert.assertTrue(!testEntity.ifWordToGuessContainsLetter('a'));
    }
}