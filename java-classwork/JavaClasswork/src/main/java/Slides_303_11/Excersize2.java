package Slides_303_11;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Excersize2 {
    public static void main(String[] args) {


        Map<Integer, String> intMap = new HashMap<Integer, String>();

        intMap.put(1, "Red");
        intMap.put(2, "Green");
        intMap.put(3, "Black");
        intMap.put(4, "White");
        intMap.put(5, "Blue");

        System.out.println("Size of the hash map: " + intMap.size());


    }
}
