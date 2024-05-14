package Slides_303_11;

import java.util.HashMap;


public class Excersize3 {
//Write a Java program to copy all mappings from the specified map to another map.
    public static void main(String[] args) {


        HashMap<Integer, String> hashMap1 = new HashMap<Integer, String>();
        HashMap<Integer, String> hashMap2 = new HashMap<Integer, String>();

        hashMap1.put(1, "red");
        hashMap1.put(2, "Green");
        hashMap1.put(3, "black");

        System.out.println("Values in first map: " + hashMap1);

        hashMap2.put(4, "white");
        hashMap2.put(5, "blue");
        hashMap2.put(6, "orange");

        System.out.println("Values in second map: " + hashMap2);

        hashMap2.putAll(hashMap1);
        System.out.println("Now values in second map" + hashMap2);



    }

}
