package z_useful;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {
    public static void main(String[] args) {

        int[] scores = {11, 81, 91, 12, 74, 76, 8, 100, 32, 56, 31, 67};
        double[] limits = {60, 70, 80, 90};

        String[] grades = {"D", "C", "B", "A"};

        ChoiceFormat cf = new ChoiceFormat( limits, grades );

        for(int i: scores) {
            System.out.println( i + ":" + cf.format( i ) );
        }
    }
}
