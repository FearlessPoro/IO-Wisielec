package dao;

import entity.WordEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class CsvDao {
    private static final String SEPARATOR = ";";

    public CsvDao(Path path) {
        setSourcePath(path);
    }

    private void setSourcePath(Path path) {
        try {
            this.source = Files.newBufferedReader(
                    path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        int randomWordIndex = random.nextInt(categoryToGuess.size()-1);

        return new WordEntity(categoryToGuess.get(randomWordIndex+1));
    }
}
