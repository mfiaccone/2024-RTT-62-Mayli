package Slides_303_11;

import java.util.HashMap;

public class Excersize6 {
    //Write a Java program to get a shallow copy of a HashMap instance. - clone
    public static void main(String[] args) {


        HashMap<Integer, String> hashMap7 = new HashMap<Integer, String>();


        hashMap7.put(4, "white");
        hashMap7.put(5, "blue");
        hashMap7.put(6, "orange");

        // this is cloning it or "shallow copy"

        HashMap<Integer, String> newhashMap7 = new HashMap <Integer, String>();
        newhashMap7 = (HashMap) hashMap7.clone();
        System.out.println("cloned hashmap: " + newhashMap7);


    }
}
