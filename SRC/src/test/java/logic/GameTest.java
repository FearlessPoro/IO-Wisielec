package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static logic.Category.ALL;

public class GameTest {

    private Game testGame;
    private Game testGameTimed;

    @Before
    public void setUp() throws Exception {
        testGame = new Game(LevelDifficulty.EASY, ALL, GameTypes.NEW_GAME, false);
        testGameTimed = new Game(LevelDifficulty.EASY, ALL, GameTypes.NEW_GAME, true);
    }

    @Test
    public void checkIfInGameTest() {
        testGame.start();
        Assert.assertTrue(testGame.checkIfInGame());
    }

    @Test
    public void serializeTest() {
        testGame.serialize();
        File file = new File(Game.class.getResource("/game.ser").getFile());
        Assert.assertTrue(file.exists());
    }

    @Test
    public void deserializeSuccessfulTest() {
        testGame.serialize();
        Assert.assertTrue(testGame.deserialize());
    }

    @Test
    public void deserializeFailedTest() {
        testGame.clearSaves();
        Assert.assertFalse(testGame.deserialize());
    }

    @Test
    public void selectedLetterTest() {
        testGame.start();
        Character character = testGame.getWordToGuess().charAt(0);
        testGame.selectedLetter(character);

        Assert.assertTrue(testGame.alreadySelectedLetter(character));
    }

    @Test
    public void selectedLetterInvalidTest() {
        testGame.start();
        int initialLives = testGame.getHearths();
        Character character = '1';

        testGame.selectedLetter(character);

        Assert.assertEquals(initialLives - 1, testGame.getHearths());
    }

    @Test
    public void selectedLetterAlreadySelectedTest() {
        testGame.start();
        Character character = testGame.getWordToGuess().charAt(0);
        int initialLives = testGame.getHearths();
        testGame.selectedLetter(character);
        testGame.selectedLetter(character);

        Assert.assertEquals(initialLives - 1, testGame.getHearths());
    }

    @Test
    public void checkWholeWordTest() {
        testGame.start();
        String word = testGame.getWordToGuess();

        Assert.assertTrue(testGame.checkWholeWord(word));
    }

    @Test
    public void checkWholeWordInvalidTest() {
        testGame.start();
        String word = testGame.getWordToGuess() + "x";

        Assert.assertFalse(testGame.checkWholeWord(word));
    }

    @Test
    public void takeEndMessageTimeOverTest() {
        testGameTimed.start();

        String message = "Czas się skończył! Przegrywasz! " + "\nSłowo do odgadnięcia: \"" + testGameTimed.getWordToGuess() + "\".";

        while(testGameTimed.getSecondsLeft() > 0) {
            testGameTimed.decrementSecondsLeft();
        }

        Assert.assertEquals(message, testGameTimed.takeEndMessage());
    }

    @Test
    public void takeEndMessageNoLivesTest() {
        testGame.start();
        String message = "Straciłeś wszystkie życia. Przegrywasz! " + "\nSłowo do odgadnięcia: \"" + testGame.getWordToGuess() + "\".";
        testGame.setLivesToZero();

        Assert.assertEquals(message, testGame.takeEndMessage());
    }

    @Test
    public void takeEndMessageWonTest() {
        testGame.start();
        String message = "Gratulacje! Słowo do odgadnięcia: " + testGame.getWordToGuess() + ".\nWygrałeś oraz masz wciąż " + testGame.getHearths() + " żyć.";

        Assert.assertEquals(message, testGame.takeEndMessage());
    }

    @Test
    public void canPlayTest() {
        testGame.start();

        Assert.assertTrue(testGame.canPlay());
    }

    @Test
    public void canPlayNoLivesTest() {
        testGame.start();
        testGame.setLivesToZero();

        Assert.assertFalse(testGame.canPlay());
    }
    
}
