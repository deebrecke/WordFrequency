import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordExperiments {

    private static Map<String, Integer> countWords(Map<String, Integer> wordMap) {
        try {
            Scanner infile = new Scanner(new File("tale.txt"));

            while (infile.hasNext()) {
                String word = infile.next();
                //use function to clean up word to remove punctuation
                word = removePunctuation(word);
                //clean up capitalization, too
                word = word.toLowerCase();
                if (wordMap.containsKey(word)) {
                    int value = wordMap.get(word);
                    value++;
                    wordMap.put(word, value);
                } else {
                    wordMap.put(word, 1);
                }
            }//end of while

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return wordMap;
    }//countwords


    public static void printMap() {
        Map<String, Integer> mapToPrint = new TreeMap<>();
        mapToPrint = countWords(mapToPrint);
        for (String key : mapToPrint.keySet()) {
            int value = mapToPrint.get(key);
            System.out.println("The word " + key + " appears " + value + " times.");

        }
    }

    /**
     * This method takes in a Map of words pulled from a file and finds the one that
     * occurs most frequently. If there are multiple words that occur the same (max) times
     * it prints out the first word.
     *
     * @param mapOfWords map with key value pair String:integer as designed in countWords method above
     *                   which is called inside this method
     */
    public static void mostFrequent(Map<String, Integer> mapOfWords) {
        Map<String, Integer> mapToCheck = countWords(mapOfWords);
        int numUses = 0;
        String mostUsedWord = "";

        for (String key : mapToCheck.keySet()) {
            int value = mapToCheck.get(key);
            if (value > numUses) {
                numUses = value;
                mostUsedWord = key;
            }
        }
        System.out.println("The word " + "'" + mostUsedWord + "'" + " appears most often at " + numUses + " times.");
    }

    public static void moreThanOne() {
        Map<String, Integer> mapToCheck = new TreeMap<>();
        mapToCheck = countWords(mapToCheck);
        Map<String, Integer> storageMap = new TreeMap<>();
        int numUses = 0;
        String mostUsedWord = "";

        for (String key : mapToCheck.keySet()) {
            int value = mapToCheck.get(key);
            if (value > numUses) {
                numUses = value;
                mostUsedWord = key;
            } else if (value == numUses) {
                storageMap.put(key, value);
            }
        }
        System.out.println("The word " + "'" + mostUsedWord + "'" + " appears most often at " + numUses + " times.");
        for (String key : storageMap.keySet()) {
            int high = storageMap.get(key);
            if (high == numUses) {
                System.out.println("And the word " + "'" + key + "'"+ " also appears " + numUses + " times.");
            }
        }
    }


    //this was from techiedelight.com
    public static String removePunctuation(String words) {
        return words.replaceAll("\\p{Punct}", "");
    }

}//end of class

