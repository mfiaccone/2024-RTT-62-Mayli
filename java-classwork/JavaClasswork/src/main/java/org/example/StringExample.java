package org.example;

public class StringExample {

    public static void main(String[] args) {

        String str = "Whatever you want to type.";

        System.out.println("The length of the string =" + str.length());

        String str2 = str.toUpperCase();

        System.out.println(str);
        System.out.println(str2);


        // 9238752034895

        String filename = "document.pdf";

        System.out.println("The file name is " + filename + "and the length is" + filename.length());

        System.out.println("The period is at index " + filename.indexOf('.'));

        System.out.println("The file extension is" + filename.substring( filename.indexOf(',') + 1));
        System.out.println("The name of the file is" + filename.substring(0, filename.lastIndexOf(',')));




    }




}
