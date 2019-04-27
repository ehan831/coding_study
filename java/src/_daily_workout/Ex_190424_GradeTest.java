package _daily_workout;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Ex_190424_GradeTest {

    public static void main(String[] args) {

        int[] score = inputScore();

        Ex_190424_GradeExpr GE = new Ex_190424_GradeExpr(score);


        GE.printScore();
        System.out.printf("총점 : %d \n", GE.getTotal());
        System.out.printf("평균점수 : %.2f \n", GE.getAverage());
        System.out.printf("최고점수: %d \n", GE.getGoodScore());
        System.out.printf("최저점수: %d \n", GE.getBadScore());

    }

    public static int[] inputScore() {
        System.out.println("처리하려는 데이터의 개수를 입력해주세요.");

        Scanner input = new Scanner(System.in);

        int num = Integer.parseInt(input.nextLine());

        int[] score = new int[num];

        System.out.println("점수들을 순서대로 입력해주세요.");
        StringTokenizer stn = new StringTokenizer(input.nextLine(), " ");

        int k = 0;
        while (stn.hasMoreTokens()) {
            score[k] = Integer.parseInt(stn.nextToken());
            k += 1;
        }
        return score;
    }
}