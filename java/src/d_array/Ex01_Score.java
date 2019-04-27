package d_array;

//public class Ex01_Score {
//    public static void main(String[] args) {
//        int sum = 0;
//        int[] score = new int[5];
//        score[0] = 80;
//        score[1] = 99;
//        score[2] = 77;
//        score[3] = 55;
//        score[4] = 81;
////        for (int i = 0; i < score.length; i++) {
////            sum += score[i];
////        }
//        for(int i:score) {
//            sum+=i;
//        }
//        System.out.println(sum/score.length);
//    }
//}

//import java.util.Scanner;
//
//public class Ex01_Score {
//    public static void main(String[] args) {
//        int sum = 0;
//        int[] score = new int[5];
//        Scanner input = new Scanner(System.in);
//
//        for(int i=0; i<=4; i++) {
//            System.out.printf("점수 %s 입력해주세요", (i+1));
//            score[i] = input.nextInt();
//        }
//        for(int i:score) {
//            sum+=i;
//        }
//        System.out.println(sum/score.length);
//    }
//}


import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01_Score {
    public static void main(String[] args) {

        int[] score = new int[5];
        Scanner input = new Scanner( System.in );

        System.out.println( "점수를 입력해주세요 ex. 99 88 77" );
        String scores = input.nextLine( );
        StringTokenizer st = new StringTokenizer( scores );

        for (int i = 0; st.hasMoreTokens( ); i++) {
            score[i] = Integer.parseInt( st.nextToken( ) );
        }

        // 총점 구하기
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += score[i];
        }
        System.out.println( total / score.length );
    }
}