package a_datatype;

import java.util.Scanner;

public class Ex05_Scanner {
    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
        System.out.print( "학생이름=>" );
        String stu = input.nextLine( );
        System.out.print( "국어점수=>" );
        int kor = input.nextInt( );
        System.out.print( "영어점수=>" );
        int eng = input.nextInt( );
        System.out.print( "수학점수=>" );
        int math = input.nextInt( );

//        int kor = 77;
//        int eng = 87;
//        int math = 99;

        // 총점을 구해서 출력
        int total = kor + eng + math;
        System.out.println( stu + "'s 총점: " + total );

        // 평균을 구해서 출력
        double avr = (double) total / 3;
        System.out.println( stu + "'s 평균: " + avr );

    }
}
