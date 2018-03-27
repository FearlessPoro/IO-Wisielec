package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CsvDaoTest {

    private CsvDao testDao;

    @Before
    public void setUp() throws Exception {
        try {
            Path path = Paths.get("src/test/resources", "sample.csv");
            Reader reader = Files.newBufferedReader(
                    path, Charset.forName("UTF-8"));
            testDao = new CsvDao(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    public void readsRecords() {
        List<List<String>> records = testDao.readRecords();

        Assert.assertEquals(2, records.size());
        Assert.assertTrue(records.contains(Arrays.asList("word1", "word2")));
        Assert.assertTrue(records.contains(Arrays.asList("word3", "word4")));
    }
}