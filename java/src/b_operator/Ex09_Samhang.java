package b_operator;

import java.util.Scanner;

/**
 * 삼항연산자
 * (조건)? A : B
 * 조건이 true 이면 A를 실행, false 이면 B를 실행
 */

public class Ex09_Samhang {
    public static void main(String[] args) {
        // if로 해보면
//        int score = 71;
//        String result = "";
//        if( score >= 80 ) result = "합격";
//        else result = "불합격";
//        뭐 이런식인데
        int score = 81;
        String result = (score >= 80) ? "합격" : "불합격";
        System.out.println( result );

        Scanner input = new Scanner( System.in );
        System.out.print( "점수 1 입력" );
        int score1 = input.nextInt( );
        System.out.print( "점수 2 입력" );
        int score2 = input.nextInt( );
        int compare = (score1 >= score2) ? score1 : score2;
        System.out.println( compare );

    }
}
