package e_method;

public class Ex09_복습 {
    public static void main(String[] args) {

        char[][] square = input();
        output(square);
    }

    static char [][] input() {
        // 두 정수와 알파벳 문자를 하나를 입력 받기
        int n=3, m=4;
        char alpha= 'F';
        char [][]square = makeSquare(n, m , alpha);
        return square;
    }

    static char[][] makeSquare(int n, int m, char alpha) {
        // (*) 입력받은 값을 이용해서 n * m 만큼의 문자 배열을 만들기
        //  F G H I
        //  J K L M
        //  N O P Q

        char [][]square = new char [n][m];
        for (int i=0; i<n; i++) {
            for (int j= 0; j<m; j++) {
                //for (char ch= alpha; ch<m; ch++)
                square[i][j] = (char)(alpha++);
            }
        }
        return square;
    }

    static void output(char [][] square) {
        // 입력받은 값을 이용해서 n * m 만큼의 문자 배열을 만들기
        for (int i=0; i<square.length; i++) {
            for (int j=0; j<square[i].length; j++) {
                System.out.print(square[i][j]+"\t");
            } System.out.println();
        }

    }

    ///// another plan

    // 입력 받았다고 치자, Scanner
//    static int n=3, m=4;
//    static char alpha = 'F';
//
//    public static void main(String[] args) {
//      char[] alpha_arr = input();
//      output(alpha_arr);
//    }
//
//    static char[] input() {
//        // 두 정수와 알파벳 문자 하나를 입력받기
//        char[] alpha_arr = makeSquare();
//        return alpha_arr;
//    }
//
//    static char[] makeSquare() {
//        // 입력받은 값을 이용해서 n * m 문자 배열을 만들기
////        F G H I
////        J K L M
////        N O P Q
//        char[] alpha_arr = new char[n*m];
//        for (char i = 0; i < (n * m); i++) {
//            alpha_arr[i] = (char)((int)alpha + i);
//        }
//        return alpha_arr;
//    }
//
//    static void output(char[] alpha_arr) {
//        for (int i = 0; i < alpha_arr.length ; i++) {
//            System.out.print( alpha_arr[i] );
//            if (alpha_arr[i] % m == 1) {
//                System.out.println( );
//            }else System.out.print(" ");
//        }
//    }
}
