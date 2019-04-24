package _daily_workout;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeMath.max;

//public class Ex_190422 {
//    public static void main(String[] args) {
//        /**-----------------------------------------------------
//        (문제 1) 영문자를 입력하여 이 문자가 소문자이면 true 을 반환 그렇지 않으면 false 을 반환하는 메소드를 작성하시오.
//         함수명 : checkLower
//         인자 : char
//         리턴(반환) : boolean
//         -----------------------------------------------------*/
//        Scanner input = new Scanner( System.in );
//        System.out.println("문자를 입력해주세요");
//        char ch = input.next().charAt(0);
//        boolean result = checkLower(ch);
//        System.out.println(result);
//    }
//
//    static boolean checkLower(char ch) {
//        if(Character.isLowerCase(ch)) {
//            return true;
//        }else return false;
//    }
//}

//
//public class Ex_190422 {
//    /**-----------------------------------------------------
//     - 2개의 int 인자인 경우는 곱셈계산 한 결과를 출력
//     - 1개의 int 인자와 1개의 char 인자인 경우는 int 인자 수 만큼 char 인자 문자를 출력
//     - 2개의 int 인자와 1개의 char 인자인 경우는 char 인자 문자를 n * m 형식의 행과 열로 출력
//     -----------------------------------------------------*/
//    public static void main(String[] args) {
//        Scanner input = new Scanner( System.in );
//
//        System.out.println("숫자나 문자를 입력해주세요.");
//        int a = new int();
//
//        p_or_t( );
//
//    }
//    static void p_or_t(int a, int b) {
//
//    }
//    static void p_or_t(int b, char c) {
//
//    }
//    static void p_or_t(int a, int b, char c) {
//
//    }
//}

public class Ex_190422 {
    /**
     n = 후보의 수
     vote = 투표의 결과. 배열
     return = 최다 득표자

     동점일 경우, 전부 배열로 리턴

     ex.
     n=5 | votes=[1,5,4,3,2,5,2,5,5,4] | return=[5]
     n=4 | votes=[1,3,2,3,2]           | return=[2,3]
     */

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println("참가 후보자 수는? 1~10");
        int candi = input.nextInt();

        System.out.println("투표인 수는? 1~100" );
        int vote_num = input.nextInt();

        int[] votes = new int[vote_num];
        for (int i = 0; i < vote_num; i++) {
            System.out.printf("어느 후보자에게 투표하시겠습니까? 1 ~ %s \n", candi);
            int vv = input.nextInt();
            if(candi >= vv) {
                votes[i] = vv;
            }else {
                System.out.println("해당 후보자가 없습니다. 다시 입력해주세요.");
                i--;
            }
        }
        for (int i = 0; i < votes.length ; i++) {
            System.out.println(votes[i]);
        }
        calc(candi, votes);
    }
    static void calc(int candi, int[] votes) {
        int[] freq = new int[candi];
        for (int i = 0; i < candi; i++) {
            int count = 0;
            for (int j = 0; j < votes.length; j++) {
                if (votes[j] == i+1) {
                    count += 1;
                } else {

                }
                freq[i] = count;
            }
        }
//        System.out.println(max(freq);
        //아직 구현 못한부분 ㅠ
    }
}