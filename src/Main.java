import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Map<String, String> dnsTable = new TreeMap<>();
//
//        dnsTable.put("greenriver.edu", "128.105.20.204");
//        dnsTable.put("superbowl.net", "201.120.100.3");
//        dnsTable.put("google.com", "101.101.101.101");
//
//        System.out.println(dnsTable);
//
//        String answer = dnsTable.get("greenriver.edu");
//        System.out.println(answer);
//
//        dnsTable.put("greenriver.edu", "1.2.3.4");
//        System.out.println(dnsTable.get("greenriver.edu"));

        Map<String, Integer> wordCounts = new TreeMap<>();
        //loads the words into the map
        WordFrequency.countWords(wordCounts);
        //must call countWords before you can call this method because otherwise map is empty
        WordFrequency.mostFrequent(wordCounts);

        //if you call it again, it adds the words to the map again and the results are doubled
        //reworked it to call the countWords method inside mostFrequent method
        WordExperiments.mostFrequent(wordCounts);

        //this prints out all the words that have the highest count
        WordExperiments.moreThanOne();

        //WordExperiments.printMap();

        LinkedMap<String, Integer> smallEx = new LinkedMap<>();
        smallEx.put("S", 0);
        smallEx.put("E", 1);
        smallEx.put("A", 2);
        smallEx.put("R", 3);
        smallEx.put("C", 4);
        smallEx.put("H", 5);
    }
}
