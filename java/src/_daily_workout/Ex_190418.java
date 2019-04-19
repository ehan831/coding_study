package _daily_workout;

import java.util.Scanner;
import java.util.StringTokenizer;

/**-----------------------------------------------------
완전검색
        모든 경우의 수를 다 따진다 문제를 해결할 때 가능한한모든 경우의 수를 따져서 문제를 해결하는 알고리즘이다 시간이 너무 많이 걸린다는 단점이 있다

        문제 : 주사위의합(정올-1599)

        철수는 주사위 두개를 가지고 있다. 이 주사위 두 개를 던질때 눈의 합이 어떤 수가 되는가가 궁금하다. 그런데 일일이 따지기 어려워 컴퓨터를 잘하는 당신에게 도움을요청하였다.
        예를 들어, 합이 9 가되는 경우는
        3 6
        4 5
        5 4
        6 3
        와 같은 경우이다.
        입력형식
        입력은 12 이하인 자연수가 주어진다.
        출력형식
        두 개의 수가 출력된다. 각각 첫번째, 두번째 주사위의눈이다.
        출력은 첫 수가 작은 수부터 먼저 출력한다

        입력예
        9
        출력예
        3 6
        4 5
        5 4
        6 3
 -----------------------------------------------------*/
//public class Ex_190418 {
//    public static void main(String[] args) {
//        //입력값
//        Scanner input = new Scanner(System.in);
//        System.out.println("숫자를 하나 입력해주세요. 2 ~ 12");
//        int hap = input.nextInt();
//
//        for(int i=1; i<=6; i++) {
//            for(int j=1; j<=6; j++) {
//                if(hap == i + j) {
//                    System.out.println(i + "" + j);
//                }
//            }
//        }
//    }
//}


/**-----------------------------------------------------
입력할 학생수를 입력하세요. 4

        4명의 국어, 영어, 수학 점수를 받아 결과 출력하기

        1째 학생의 성적을 입력 -> 88/77/66
        2째 학생의 성적을 입력 -> 50/40/70
        3째 학생의 성적을 입력 -> 44/33/22
        4째 학생의 성적을 입력 -> 55/50/70


        [결과]
        1째 학생의 총점 xxx 이고 평균은 ooo 입니다
        2째 학생의 총점 xxx 이고 평균은 ooo 입니다
        3째 학생의 총점 xxx 이고 평균은 ooo 입니다
        4째 학생의 총점 xxx 이고 평균은 ooo 입니다
        국어과목  총점 xxx 이고 평균은 ooo 입니다
        영어과목  총점 xxx 이고 평균은 ooo 입니다
        수학과목  총점 xxx 이고 평균은 ooo 입니다
 -----------------------------------------------------*/
public class Ex_190418 {
    public static void main(String[] args) {

        /** */
        Scanner input = new Scanner( System.in );

        System.out.println( "입력할 학생 수를 입력하세요(숫자): " );
        int stu_num = input.nextInt( ); input.nextLine();

        String[] sub = {"국어", "영어", "수학"};
        int sub_num = sub.length;

        int[][] score_array = new int[stu_num][sub_num];

        for (int i = 0; i < stu_num; i++) {
            System.out.printf( "%s 번째 학생의 성적을 입력해주세요(ex. 88/77/66) \n", (i + 1) );
            String score_input = input.nextLine( );
//            System.out.println(score_input);
            StringTokenizer st = new StringTokenizer( score_input, "/" );

            for (int j = 0; j < sub_num; j++) {
                score_array[i][j] = Integer.parseInt(st.nextToken( ));
//                System.out.println( score_array[i][j] );
            }
        }

        //출력 - 평균, 등등
        for (int i = 0; i < stu_num; i++) {
            int total = 0;
            for (int j = 0; j < sub_num; j++) {
                total += score_array[i][j];
            }
            int avg = total / sub_num;
            System.out.printf( "%s째 학생의 총점 %s 이고 평균은 %s 입니다 \n", (i + 1), total, avg ); }

        //과목 별-
    }
}