package org.example;

public class KBA1Review {

    private Integer x; //when we define a variable outside of a function it is called a class variable
    //vs local variable inside a function -


    public static void main(String[] args) {


        //these are valid ways of creating an array
        //know how to make an array
        int[] arr = new int[12];
        int[] arr1; arr1 = new int[12];
        int[] arr2 = {1, 2, 3, 4, 5};

        //it will show you some that are not correct

        String a = "AFTER";
        String b = "BETA";
        String c = "CAPTURE";

        //these two functions are not the same
        printOutput(a + b + c); //the compiler is going to combine into a single string and then put to lowercase
        printOutput(a,b,c); // this will print each

    }

    public static void printOutput(String output) {
        System.out.println(output.toLowerCase());

    }

    public static void printOutput(String a, String b, String c) {
        System.out.println(a + b + c);
    }
}