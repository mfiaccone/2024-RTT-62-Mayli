package Slides_303_11;

import java.util.HashMap;

public class Excersize5 {
    //Write a Java program to check whether a map contains key-value mappings
    // (empty) or not.

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap5 = new HashMap<Integer, String>();


        hashMap5.put(4, "white");
        hashMap5.put(5, "blue");
        hashMap5.put(6, "orange");

        // this checks if the map is empty
        boolean result = hashMap5.isEmpty();

        System.out.println(result); // prints false

        //removing all the elements from the map
        hashMap5.clear();

        //check now
        boolean result2 = hashMap5.isEmpty();

        System.out.println(result2); //prints true

    }
}
