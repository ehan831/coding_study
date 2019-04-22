package e_method;

import java.util.Scanner;

public class Ex03_성적 {

    static String[] sublist = { "국어", "영어", "수학"};

    public static void main(String[] args) {
        int[] score = input();
        int sum = calc(score);
        output(sum);
    }

    static int[] input() {
        // 국영수 점수 입력 받기
        Scanner input = new Scanner( System.in );
        int[] score = new int[sublist.length];

        for(int i=0; i<sublist.length; i++) {
            System.out.printf("%s 점수를 입력해주세요", sublist[i]);
            score[i] = input.nextInt();
        }

        return score;

    }
    static int calc(int[] score) {
        // input() 에서 받은 점수들의 합과 평균 구하기

        int sum = 0;

        for(int i=0; i<sublist.length; i++) {
            sum += score[i];
        }
        return sum;
    }

    static void output(int sum) {
        // calc() 구한 합과 평균을 출력
        int avg = sum/sublist.length;
        System.out.println("합은" + sum + ", 평균은" + avg + " 입니다." );
    }
}
