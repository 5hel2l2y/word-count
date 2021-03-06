import java.io.*;
import java.util.*;

public class WordCount {
  public static void main(String[] args) throws FileNotFoundException {
    // take user specified file
    Scanner scan = new Scanner(System.in);
    System.out.println("Provide a full file path:");
    String filePath = scan.next();
    scan.close();
    
    // scan for words
    Scanner file = new Scanner(new File(filePath));

    Map<String, Integer> counts = new HashMap<String, Integer>();

    // for each words, append new words to list and add count
    while(file.hasNext()) {
      // clean up data
      String next = file.next().toLowerCase().replaceAll("[,]|[.]*", "");
      
      if(!counts.containsKey(next)) {
        counts.put(next, 1);
      } else {
        counts.put(next, counts.get(next) + 1);
      }
    }
    
    // sort list by count
    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(counts.entrySet());

    Collections.sort(list, Collections.reverseOrder(new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> listOne, Map.Entry<String, Integer> listTwo) {
        return (listOne.getValue()).compareTo(listTwo.getValue());
      }
    }));

    // print list
    list.forEach((count) -> System.out.println(count));
  }
}