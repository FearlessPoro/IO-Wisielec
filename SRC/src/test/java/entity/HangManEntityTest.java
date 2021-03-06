package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HangManEntityTest {

    private HangManEntity testEntity;

    @Before
    public void setUp() throws Exception {
        testEntity = new HangManEntity();
    }

    @Test
    public void getHearthsTest() {
        int expectedLives = 10;

        int resultLives = testEntity.getHearths();

        Assert.assertEquals(expectedLives, resultLives);
    }

    @Test
    public void decrementLivesTest() {
        int expectedLives = 9;

        testEntity.decrementLives();
        int resultLives = testEntity.getHearths();

        Assert.assertEquals(expectedLives, resultLives);
    }

    @Test
    public void isAliveTest() {
        boolean isAlive = testEntity.isAlive();

        Assert.assertTrue(isAlive);
    }

    @Test
    public void isDeadTest() {
        for (int i = 0; i < 10; i++) {
            testEntity.decrementLives();
        }

        boolean isAlive = testEntity.isAlive();

        Assert.assertFalse(isAlive);
    }
}