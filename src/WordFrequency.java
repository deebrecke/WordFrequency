import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {

    public static void countWords(Map<String, Integer> wordMap){
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

            //write a loop to walk through items in the map
            for (String key : wordMap.keySet()) {
                int value = wordMap.get(key);
                System.out.println("The word " + key + " appears " + value + " times.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }//countwords

    /**
     * This method takes in a Map of words pulled from a file and finds the one that
     * occurs most frequently. If there are multiple words that occur the same (max) times
     * it prints out the first word.
     * @param wordMap map with key value pair String:integer as designed in countWords method above
     * This method requires countWords to be called in main before it will work.
     *  I did a work-around (in WordExperiments class) in which countWords is not void but returns a map so that
     *  it is just one call
     */
    public static void mostFrequent(Map<String, Integer> wordMap){
        int numUses = 0;
        String mostUsedWord = "";

        for (String key : wordMap.keySet()) {
            int value = wordMap.get(key);
            if(value > numUses){
                numUses = value;
                mostUsedWord = key;
            }
        }

        System.out.println("The word " + "'" +mostUsedWord + "'"+ " appears most often at " + numUses +" times." );
    }

    //this was from techiedelight.com
    public static String removePunctuation(String words) {
        return words.replaceAll("\\p{Punct}", "");
    }
}//class