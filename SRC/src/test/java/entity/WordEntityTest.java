package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordEntityTest {
    private WordEntity testEntity;
    private final String testWord = "test";
    private String testUnknownWord = "____";

    @Before
    public void setUp() {
        testEntity = new WordEntity(testWord);
    }

    @Test
    public void revealLetter() {
        String revealedLetter = "t__t";

        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');
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
        Assert.assertFalse(testEntity.alreadySelectedLetter('t'));
    }

    @Test
    public void notAllLettersRevealed() {
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');

        Assert.assertFalse(testEntity.allLettersRevealed());
    }

    @Test
    public void allLettersRevealed() {
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('e');
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('s');

        Assert.assertTrue(testEntity.allLettersRevealed());
    }

    @Test
    public void wordToGuessContainsLetter() {
        Assert.assertTrue(testEntity.doesTheWordToGuessContainsLetter('t'));
    }

    @Test
    public void wordToGuessNotContainsLetter() {
        Assert.assertFalse(testEntity.doesTheWordToGuessContainsLetter('a'));
    }
}