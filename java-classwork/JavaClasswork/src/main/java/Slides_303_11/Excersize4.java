package Slides_303_11;

import java.util.HashMap;

public class Excersize4 {
//Write a Java program to remove all mappings from a map.

    public static void main(String[] args) {


        HashMap<Integer, String> hashMap4 = new HashMap<Integer, String>();


        hashMap4.put(4, "white");
        hashMap4.put(5, "blue");
        hashMap4.put(6, "orange");

        System.out.println("Values in second map: " + hashMap4);

        hashMap4.clear();

        System.out.println("Bye bye hashmap: " + hashMap4);

    }

}
