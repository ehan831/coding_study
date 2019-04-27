/**
 * -----------------------------------------------------
 * [ 문제 1 ] 아래와 같이 출력하기
 * A
 * AB
 * ABC
 * ABCD
 * :
 * ABCDEFGHIJKLMNOPQRSTUVW
 * ABCDEFGHIJKLMNOPQRSTUVWX
 * ABCDEFGHIJKLMNOPQRSTUVWXY
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * -----------------------------------------------------
 */
public class Ex_190417 {
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            for (char ch = 'A'; ch <= ('A' + i); ch++) {
                System.out.print( ch );
            }
            System.out.println( );
        }
    }
}


/**
 * -----------------------------------------------------
 * [ 문제 2 ] 아래와 같이 출력하기
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * ABCDEFGHIJKLMNOPQRSTUVWXY
 * ABCDEFGHIJKLMNOPQRSTUVWX
 * ABCDEFGHIJKLMNOPQRSTUVW
 * ABCDEFGHIJKLMNOPQRSTUV
 * :
 * ABC
 * AB
 * A
 * ----------------------------------------------------*/
//public class Ex_190417 {
//    public static void main(String[] args) {
//        for(int i=0; i<26; i++) {
//            for (char ch = 'A'; ch <= ('Z'-i); ch++) {
//                System.out.print( ch );
//            }
//            System.out.println();
//        }
//    }
//}


/**-----------------------------------------------------
 [ 문제 3 ] 아래와 같이 출력하기
 ABCDEFGHIJKLMNOPQRSTUVWXYZ
 BCDEFGHIJKLMNOPQRSTUVWXYZ
 CDEFGHIJKLMNOPQRSTUVWXYZ
 DEFGHIJKLMNOPQRSTUVWXYZ
 :
 XYZ
 YZ
 Z
 -----------------------------------------------------*/
//public class Ex_190417 {
//    public static void main(String[] args) {
//        for(int i=0; i<26; i++) {
//            for (char ch = (char)('A'+i); ch <= 'Z'; ch++) {
//                System.out.print( ch );
//            }
//            System.out.println();
//        }
//    }
//}


/**-----------------------------------------------------
 [ 문제 4 ] 아래와 같이 출력하기
 Z
 ZY
 ZYX
 :
 ZYXWVUTSRQPONMLKJIHGFEDC
 ZYXWVUTSRQPONMLKJIHGFEDCB
 ZYXWVUTSRQPONMLKJIHGFEDCBA
 -----------------------------------------------------*/
//public class Ex_190417 {
//    public static void main(String[] args) {
//        for(int i=0; i<26; i++) {
//            for (char ch = 'Z'; ch >= 'Z'-i; ch--) {
//                System.out.print( ch );
//            }
//            System.out.println();
//        }
//    }
//}


/**-----------------------------------------------------
 [ 문제 5 ] 아래와 같이 출력하기
 ABCDEFGHIJKLMNOPQRSTUVWXYZ
 BCDEFGHIJKLMNOPQRSTUVWXYZ
 CDEFGHIJKLMNOPQRSTUVWXYZ
 DEFGHIJKLMNOPQRSTUVWXYZ
 :
 WXYZ
 XYZ
 YZ
 Z
 -----------------------------------------------------*/
//public class Ex_190417 {
//    public static void main(String[] args) {
//        // 모든 라인을 출력
//        for (int i = 0; i < 26; i++) {
//            for (int j=0; j<i; j++) {
//                System.out.print(" ");
//            }
//            for (char ch = (char) ('A' + i); ch <= 'Z'; ch++) {
//                System.out.print(ch);
//            }
//            System.out.println( );
//        }
//    }
//}
