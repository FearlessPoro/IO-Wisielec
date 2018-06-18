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
    public void revealLetterTest() {
        String revealedLetter = "t__t";

        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');
        char resultWord[] = testEntity.getUnknownWord();

        Assert.assertArrayEquals(revealedLetter.toCharArray(), resultWord);
    }

    @Test
    public void getWordToGuessTest() {
        String resultWord = testEntity.getWordToGuess();

        Assert.assertEquals(testWord, resultWord);
    }

    @Test
    public void getUnknownWordTest() {
        char resultWord[] = testEntity.getUnknownWord();

        Assert.assertArrayEquals(testUnknownWord.toCharArray(), resultWord);
    }

    @Test
    public void addToAlreadySelectedLetterTest() {
        testEntity.addToAlreadySelectedLetter('t');

        Assert.assertTrue(testEntity.alreadySelectedLetter('t'));
    }

    @Test
    public void alreadySelectedLetterTest() {
        testEntity.addToAlreadySelectedLetter('e');

        Assert.assertTrue(testEntity.alreadySelectedLetter('e'));
        Assert.assertFalse(testEntity.alreadySelectedLetter('t'));
    }

    @Test
    public void notAllLettersRevealedTest() {
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');

        Assert.assertFalse(testEntity.allLettersRevealed());
    }

    @Test
    public void allLettersRevealedTest() {
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('t');
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('e');
        testEntity.revealAllDuplicatesIfWordToGuessContainsLetter('s');

        Assert.assertTrue(testEntity.allLettersRevealed());
    }

    @Test
    public void wordToGuessContainsLetterTest() {
        Assert.assertTrue(testEntity.doesTheWordToGuessContainsLetter('t'));
    }

    @Test
    public void wordToGuessNotContainsLetterTest() {
        Assert.assertFalse(testEntity.doesTheWordToGuessContainsLetter('a'));
    }
}