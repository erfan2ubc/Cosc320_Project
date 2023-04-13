package project_320;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();

        // Read in corpus file
        String corpusFilePath = "corpus.txt";
        String corpusOfText = readFile(corpusFilePath);
//        File path = new File("corpus.txt");
//        FileWriter writer = new FileWriter(path);
//
//
//        //Creating a File object for directory
//        File directoryPath = new File("C:\\Users\\moham\\Cosc320\\Keyword replacement in a corpus\\test2");
//        //List of all files and directories
//        File filesList[] = directoryPath.listFiles();
//        System.out.println("List of files and directories in the specified directory:");
//        for(File file : filesList)
//        {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            String st;
//            while ((st = br.readLine()) != null) {
//                try {
//                    String[] columns = st.split(",");
//                    String forthColumn = columns[3];
//
//                    String[] words = forthColumn.split("\\s+");
//                    for (int i = 0; i < words.length; i++) {
//                        String word = words[i].toLowerCase();
//                        List<Integer> positions = new ArrayList<>();
//                        positions.add(i);
//                        System.out.print(word + " ");
//                        writer.write(word + " ");
//
//                    }
//                    System.out.println();
//                    writer.write("\n");
//
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    continue;
//                }
//
//            }
//        }

        // Read in abbreviations file
        String abbreviationsFilePath = "abbreviations.txt";
        List<String> listOfAbbreviations = readLinesFromFile(abbreviationsFilePath);

        // Preprocess abbreviations
        List<String> abbreviations = AbbreviationProcessor.sortByLength(listOfAbbreviations);

        // Create index of corpus
        Map<String, List<Integer>> index = AbbreviationProcessor.createIndex(corpusOfText);

        // Iterate through abbreviations
        for (String abbreviation : abbreviations) {
            // Search index for abbreviation
            List<Integer> matches = AbbreviationProcessor.searchIndex(abbreviation, index);

            // If abbreviation found, use string matching algorithm
            if (!matches.isEmpty()) {
                String closestMatch = AbbreviationProcessor.stringMatchingAlgorithm(abbreviation, matches, abbreviation);

                // Replace abbreviation with closestMatch
                corpusOfText = AbbreviationProcessor.replaceAbbreviation(abbreviation, closestMatch, corpusOfText);
            }
        }

        // Output corpus with abbreviations replaced
        AbbreviationProcessor.outputCorpus(corpusOfText);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }

    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    public static List<String> readLinesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }
}

