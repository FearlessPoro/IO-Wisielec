package dao;

import logic.Category;
import logic.LevelDifficulty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class CsvDaoTest {

    private CsvDao testDao;

    @Before
    public void setUp() {
        String path = "sample.csv";
        Category category = Category.SPORT;
        LevelDifficulty level = LevelDifficulty.EASY;
        testDao = new CsvDao(path, category, level);
    }

    @Test
    public void readRecordsTest() {
        List<List<String>> records = testDao.readRecords();

        Assert.assertEquals(90, records.size());
    }

    @Test
    public void canAddTest() {
        String wordToAdd = "testword";
        String successMessage = "Haslo dodane do bazy";

        try {
            Assert.assertEquals(successMessage, testDao.canAdd(wordToAdd, wordToAdd));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canAddNotMatchingTest() {
        String wordToAdd = "testword";
        String wordToAddConfirmed = "wordtest";
        String failureMessage = "Hasla nie zgadzaja sie";

        try {
            Assert.assertEquals(failureMessage, testDao.canAdd(wordToAdd, wordToAddConfirmed));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canAddTooLongTest() {
        String wordToAdd = "testwordtestwordtestwordtestword";
        String failureMessage = "Nieprawidlowa dlugosc hasla";

        try {
            Assert.assertEquals(failureMessage, testDao.canAdd(wordToAdd, wordToAdd));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canAddTooShortTest() {
        String wordToAdd = "a";
        String failureMessage = "Nieprawidlowa dlugosc hasla";

        try {
            Assert.assertEquals(failureMessage, testDao.canAdd(wordToAdd, wordToAdd));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canAddNoLettersTest() {
        String wordToAdd = "12345";
        String failureMessage = "Haslo musi skladac sie z liter";

        try {
            Assert.assertEquals(failureMessage, testDao.canAdd(wordToAdd, wordToAdd));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}