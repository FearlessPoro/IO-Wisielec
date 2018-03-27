package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordEntityTest {
    private WordEntity testEntity;
    private final String testWord = "test";
    private String testUnknownWord = "____";

    @Before
    public void setUp() throws Exception {
        testEntity = new WordEntity(testWord);
    }

    @Test
    public void revealLetter() {
        String revealedFirstLetter = "t___";

        testEntity.revealLetter(0);
        char resultWord[] = testEntity.getUnknownWord();

        Assert.assertArrayEquals(revealedFirstLetter.toCharArray(), resultWord);
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
}