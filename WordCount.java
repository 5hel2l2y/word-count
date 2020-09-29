import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
  public static void main(String[] args) throws FileNotFoundException {
    // take user specified file
    Scanner scan = new Scanner(System.in);
    System.out.println("Provide a full file path:");
    String filePath = scan.next();
    scan.close();
    
    // scan for words
    Scanner file = new Scanner(new File(filePath));

    // for each words, append new words to list and add count
    while(file.hasNext()) {
      // clean up data
      String next = file.next().toLowerCase().replaceAll("[,]|[.]*", "");
      
      System.out.println(next);
    }
    
    // sort list by count
    // print list
  }
}