package SBA2Q2;

import java.text.DecimalFormat;

public class Football implements Sport {

    private int[] playerIDs;

    public Football() {
        playerIDs = new int[12];
        for ( int pos = 1; pos < playerIDs.length; pos++) {
            playerIDs[pos] = 1;
        }
        System.out.println("A new football team has been formed");
    }

    @Override
    public void calculateAvgAge(int[] age) {
        double sum = 0;
        for ( int a : age ) {
            sum = sum +a;
        }

        double avgAge = sum / age.length;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("The average age of the team is " + df.format(avgAge));
    }

    @Override
    public void retirePlayer(int id) {
        if (playerIDs[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIDs[id] = -1;
            System.out.println("Player with id: " + id + " has retired");

        }
    }

    public void playerTransfer(int fee, int id) {
        if (playerIDs[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            //do you still need to do this? who knows
            //if this is not working on the SBA try adding this back in
            //playerIDs[id] = -1;
            System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);

        }
    }
}
