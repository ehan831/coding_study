package d_array;

public class Ex06_동적배열 {
    public static void main(String[] args) {


        /**-----------------------------------------------------
         *---
         **--
         ***-
         ****
         -----------------------------------------------------*/
        char[][] star = new char[4][4];  // 뒤에 몇 개 넣을 것인지 정의함

        for(int i=0; i<star.length; i++) {
            for(int j=0; j<i+1; j++) {
                star[i][j] = '*';
            }
        }

        /**-----------------------------------------------------
         *
         **
         ***
         ****
         -----------------------------------------------------*/
//        char[][] star = new char[4][];  // 뒤에 몇 개 넣을 것인지 정의하지 않았다!!
//
//        for(int i=0; i<star.length; i++) {
//            star[i] = new char[i+1];
//            for(int j=0; j<i+1; j++) {
//                star[i][j] = '*';
//            }
//        }

        for(int i=0; i<star.length; i++) {
            for (int j=0; j<star[i].length; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println( );
        }
    }
}
