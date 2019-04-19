package c_control;

import java.util.Scanner;

/**
 * for( 초기값; 조건문; 증가식)
 * {
 *     반복할 문장들
 * }
 */

public class Ex05_for개념 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println( i );
            sum += i;   // sum = sum + i;
        }
        System.out.println( sum );
    }
}

//    public static void main(String[] args) {
//        int sum_odd = 0;
//        int sum_even = 0;
//        for (int i = 1; i <= 100; i++) {
//            if (i%2 == 0) {
//                sum_even += i;
//                System.out.println(i);
//            }else {
//                sum_odd += i;
//                System.out.println(i);
//            }
//        }
//        System.out.println("짝수의 합: " + sum_even);
//        System.out.println("홀수의 합: " + sum_odd);
//    }
//}

/** 다른 방법으로 해보기 */
//    public static void main(String[] args) {
//        int sum_odd = 0, sum_even = 0;
//        for (int i = 1; i <= 100; i+=2) {
//            sum_odd += i;
//            sum_even += (i+1);
//        }
//        System.out.println("짝수의 합: " + sum_even);
//        System.out.println("홀수의 합: " + sum_odd);
//    }
//}

/** 대문자 A ~ Z 출력해보기 */
//    public static void main(String[] args) {
//        for(char c='A'; c<='Z'; c++) {
//            System.out.println(c);
//        }
//    }
//}

/** 역순으로 */
//    public static void main(String[] args) {
//        for(char c='Z'; c>='A'; c-=1) {
//            System.out.println(c);
//        }
//    }
//}

/**-----------------------------------------------------
 1 2 3 4 5
 6 7 8 9 10
 11 12 13 14 15
 로 출력해보자
-----------------------------------------------------*/
//    public static void main(String[] args) {
//        for(int i = 1; i <= 15; i++) {
//            System.out.print(i + " ");
//            if(i%5 == 0) System.out.println();
//        }
//    }
//}

