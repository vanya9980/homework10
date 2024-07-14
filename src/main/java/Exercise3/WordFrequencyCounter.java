package Exercise3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class WordFrequencyCounter {

    public static void main(String[] args) {
        String filename = "src\\main\\java\\Exercise3\\words.txt";
        try {
            Map<String, Integer> wordFreq = countWordFrequency(filename);
            printWordFrequency(wordFreq);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWordFrequency(String filename) throws IOException {
        Map<String, Integer> wordFreq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
                scanner.close();
            }
        }

        return wordFreq;
    }

    public static void printWordFrequency(Map<String, Integer> wordFreq) {
        // Create a TreeMap to sort the entries based on frequency
        TreeMap<Integer, String> sortedFreqMap = new TreeMap<>((a, b) -> b - a); // Descending order

        // Populate TreeMap with frequency as key and word as value
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            sortedFreqMap.put(entry.getValue(), entry.getKey());
        }

        // Print the results sorted by frequency
        for (Map.Entry<Integer, String> entry : sortedFreqMap.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}