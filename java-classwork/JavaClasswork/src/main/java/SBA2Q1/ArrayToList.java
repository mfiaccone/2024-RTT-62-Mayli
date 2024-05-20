package SBA2Q1;

import java.util.ArrayList;

public class ArrayToList {

    private ArrayList<String> arrayToList = new ArrayList<>(); // this is one way to do it

    public ArrayToList() {
        arrayToList = new ArrayList<>();
    }
    //this is another way to do it, this is part one of question 2

    public void convert(String[] a) {
        for ( int pos = 0; pos < a.length; pos++ ) {
            arrayToList.add(a[pos]);
            System.out.println("I have added the string: " + a[pos] + " at the index: " + a[pos]);
        }
    } // this is part two of question two

    public void replace(int idx) {
        //what we are doing here is getting the actual string that is in the arrayToList before we overwrite it
        String value = arrayToList.get(idx);

        //set function takes 2 args.. first is the position to set, the second is the value to set
        arrayToList.set(idx, "");

        System.out.println("I have replaced the string: " + value + " with a null string");

        //this is part three of question 2
    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for (String s : arrayToList) { //we can use a new style because we don't care about the index
            if (!s.equals("")) {
                result.add(s);
            }
        }
        return result;

        //this is the last part of question 2
    }

    //this is the runner - we don't need this for the kba but just to see it working

    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();

        String[] strArray = {"one", "two", "three", "four", "five"};


    }
}
