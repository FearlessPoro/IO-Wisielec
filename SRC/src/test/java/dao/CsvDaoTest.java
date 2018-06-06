package dao;

import logic.Category;
import logic.LevelDifficulty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

        Assert.assertEquals(19, records.size());
    }

}