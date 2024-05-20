package Slides_303_14;

public class FunctionalKBA {

    public static void main(String[] args) {
        // this and the implementation below are the same
        MyFunctionalInterfaceKBA fi = n -> {
            return n * n;
        };

        MyFunctionalInterfaceKBA fi1 = new MyFunctionalInterfaceKBA() {
            @Override
            public Integer sqr(int a) {
                return a * a;
            }
        };

        System.out.println(fi.sqr(5));
    }
}
