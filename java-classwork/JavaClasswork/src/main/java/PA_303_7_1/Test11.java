package PA_303_7_1;

import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many favorite things do you have? ");
        int numFavorites = scanner.nextInt();


        String[] favoriteThings = new String[numFavorites];

        scanner.nextLine();


        for (int i = 0; i < numFavorites; i++) {
            System.out.print("Enter each favorite: " );
            favoriteThings[i] = scanner.nextLine();
        }


        System.out.println("Your favorite things are");
        for (String thing : favoriteThings) {
            System.out.println(thing);
        }

    }
}
