package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Integer> L = new ArrayList<>(N);

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
            }

        }

        int Q = scanner.nextInt();

        for (int i = 0; i < Q; i++) {
            String queryType = scanner.next();
            if (queryType.equals("insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                L.add(x, y); // Insert y at index x
            } else if (queryType.equals("delete")) {
                int x = scanner.nextInt();
                L.remove(x); // Delete element at index x
            }
        }

        for (int num : L) {
            System.out.print(num + " ");
        }
        scanner.close();

    }
}
