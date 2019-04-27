package _daily_workout;

import java.util.Arrays;

public class Ex_190424_GradeExpr {
    static int[] jumsu;
    private double average;
    private int total;
    private int goodscore;
    private int badscore;


    public Ex_190424_GradeExpr(int jumsu[]) {
        this.jumsu = jumsu;
    }

    public double getAverage() {
        double average = (double) getTotal() / jumsu.length;
        return average;
    }

    public int getTotal() {
        int total = 0;
        for (int i:jumsu) {
            total += jumsu[i];
        }
        return total;
    }


    public int getGoodScore() {
        Arrays.sort(jumsu);
        goodscore = jumsu[jumsu.length - 1];
        return goodscore;
    }

    public int getBadScore() {
        Arrays.sort(jumsu);
        badscore = jumsu[0];
        return badscore;
    }

    public void printScore() {
        System.out.print("점수들 : ");
        for (int i = 0; i < jumsu.length; i++) {
            System.out.print(jumsu[i] + ", ");
        }
        System.out.println();
    }
}