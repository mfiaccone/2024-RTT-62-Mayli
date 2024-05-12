package PA_303_10_3;

public class LibraryInterfaceDemo {
        public static void main(String[] args) {
            // test case one
            System.out.println("Test case #1:");
            LibraryUser kidUser1 = new KidUser(10, "Kids");
            kidUser1.registerAccount();
            kidUser1.requestBook("Kids");

            LibraryUser kidUser2 = new KidUser(18, "Fiction");
            kidUser2.registerAccount();
            kidUser2.requestBook("Fiction");

            // test case two
            System.out.println("\nTest case #2:");
            LibraryUser adultUser1 = new AdultUser(5, "Kids");
            adultUser1.registerAccount();
            adultUser1.requestBook("Kids");

            LibraryUser adultUser2 = new AdultUser(23, "Fiction");
            adultUser2.registerAccount();
            adultUser2.requestBook("Fiction");
        }
}

