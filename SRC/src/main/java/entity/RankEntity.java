package entity;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RankEntity implements Serializable {

    static class Record implements Serializable {
        Integer points;
        String wordToGuess;

        Record(Integer points, String wordToGuess) {
            this.points = points;
            this.wordToGuess = wordToGuess;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Record)) return false;
            Record record = (Record) o;
            return Objects.equals(points, record.points) &&
                    Objects.equals(wordToGuess, record.wordToGuess);
        }

        @Override
        public int hashCode() {
            return Objects.hash(points, wordToGuess);
        }
    }

    private List<Record> rank =
            new ArrayList<>(5);

    public void addToRank(Integer points, String wordToGuess) {
        rank.add(new Record(points, wordToGuess));

        rank = rank.stream()
                .distinct()
                .sorted(Comparator.comparing(a -> (-a.points)))
                .limit(5)
                .collect(Collectors.toList());
    }

    // only used in testing
    public Record getScoreAtSpecificIndex(int index) {
        return rank.get(index);
    }

    public int  getNumberOfRecords() {
        return rank.size();
    }

    public static void serialize(RankEntity rank) {
        String dir = RankEntity.class.getResource("/").getFile();
        try (FileOutputStream fileOut = new FileOutputStream(dir + "/rank.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(rank);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static RankEntity deserialize() {
        RankEntity rank = new RankEntity();

        URL url = RankEntity.class.getResource("/rank.ser");
        String dir = url != null ? url.getFile() : "";
        File f = new File(dir);

        if (f.exists() && !f.isDirectory()) {
            try (FileInputStream fileIn = new FileInputStream(dir);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                rank = (RankEntity) in.readObject();
                clearSaves();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }
        }

        return rank;
    }

    private static void clearSaves() {

        URL url = RankEntity.class.getResource("/rank.ser");
        String dir = url != null ? url.getFile() : "";
        File f = new File(dir);
        if (f.exists() && !f.isDirectory()) {
            if (f.delete()) {
                System.out.println("Usunieto save");
            }
        }
    }
}
