package Slides_303_13;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws Exception {

        // .. means go up one directory from where you are
        // . means the current directory where I am right now

        File f = new File(".");
        System.out.println(f.getAbsolutePath());

        File[] files = f.listFiles();
        try {
        for (File file : files) {
            System.out.println("    " + file.getAbsolutePath());
            if (file.isDirectory()) {
                System.out.println(" is a directory");
            } else {
                System.out.println(" is a file");
            }
        }


        File file = new File(".\\newfile.txt");
        file.createNewFile();

    } catch (IOException e){
            System.out.println(e.getMessage());
        }

        File code = new File("C:\\Users\\Anson. R\\development\\2024-RTT-62\\java-classwork\\JavaClasswork\\src\\main\\java\\Slides_303_13");

        File relative = new File("..\\..\\New Folder\\newfile.txt");




    }
}
