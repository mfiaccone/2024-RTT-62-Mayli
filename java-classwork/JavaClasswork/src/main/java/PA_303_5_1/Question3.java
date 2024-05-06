package PA_303_5_1;

public class Question3 {
    public static void main(String[] args) {

        double initialTuition = 10000;
        double newTuition = initialTuition;
        final double percent = .07;
        int year = 0;

        for (int i = 0; newTuition <= (initialTuition * 2); i++) {
            newTuition = (1 + percent) * newTuition;
            year++;
        }
        System.out.println("Tuition will double in " + year + " years.");

    }
}

