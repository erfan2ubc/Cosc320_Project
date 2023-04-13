package project_320;
import java.util.*;

public class AbbreviationProcessor {

    // Preprocess abbreviations
    public static List<String> sortByLength(List<String> listOfAbbreviations) {
        Collections.sort(listOfAbbreviations, Comparator.comparingInt(String::length).reversed());
        return listOfAbbreviations;
    }

    // Create index of corpus
    public static Map<String, List<Integer>> createIndex(String corpusOfText) {
        Map<String, List<Integer>> index = new HashMap<>();
        String[] words = corpusOfText.split("\\W+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            List<Integer> positions = index.getOrDefault(word, new ArrayList<>());
            positions.add(i);
            index.put(word, positions);
        }
        return index;
    }

    // Search index for abbreviation
    public static List<Integer> searchIndex(String abbreviation, Map<String, List<Integer>> index) {
        return index.getOrDefault(abbreviation.toLowerCase(), new ArrayList<>());
    }

    // String matching algorithm
    public static String stringMatchingAlgorithm(String abbreviation, List<Integer> matches, String corpusOfText) {
        String closestMatch = "";
        int minDistance = Integer.MAX_VALUE;
        for (Integer match : matches) {
            String word = getWordAtIndex(match, corpusOfText);
            int distance = computeLevenshteinDistance(abbreviation, word);
            if (distance < minDistance) {
                minDistance = distance;
                closestMatch = word;
            }
        }
        return closestMatch;
    }

    public static String getWordAtIndex(int index, String corpusOfText) {
        String[] words = corpusOfText.split("\\s+");
        return words[index];
    }

    // Compute Levenshtein Distance between two strings
    public static int computeLevenshteinDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                        distance[i - 1][j - 1] + cost);
            }
        }
        return distance[s1.length()][s2.length()];
    }

    // Replace abbreviation with closest match
    public static String replaceAbbreviation(String abbreviation, String closestMatch, String corpusOfText) {
        return corpusOfText.replace(abbreviation, closestMatch);
    }

    // Output corpus with abbreviations replaced
    public static void outputCorpus(String corpusOfText) {
        System.out.println(corpusOfText);
    }
}



