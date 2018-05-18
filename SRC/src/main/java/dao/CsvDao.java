package dao;

import entity.WordEntity;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class CsvDao {
    private static final String SEPARATOR = ";";

    public CsvDao(String fileName) {
        setSourcePath(fileName);
    }

    private void setSourcePath(String fileName) {
        this.source = new BufferedReader(
                        new InputStreamReader(this.getClass().getResourceAsStream("/database/" + fileName)));
    }

    private Reader source;

    List<List<String>> readRecords() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public WordEntity getRandomWord() {
        List<List<String>> allWords = readRecords();

        Random random = new Random();
        int randomCategoryIndex = random.nextInt(allWords.size());
        List<String> categoryToGuess = allWords.get(randomCategoryIndex);
        int randomWordIndex = random.nextInt(categoryToGuess.size() - 1);

        return new WordEntity(categoryToGuess.get(randomWordIndex + 1));
    }
}
