package d_array;

public class Ex05_Lotto {
    public static void main(String[] args) {

        /** pick 6 numbers, 5 times */
        int[][] lotto = new int[5][6];

        for(int i=0; i<lotto.length; i++) {
            for (int j=0; j<lotto[i].length;j++) {
                lotto[i][j] = (int)(Math.random( )*45)+1;
                for(int k=0; k<j; k++) {
                    if( lotto[i][k] == lotto[i][j]) j--;
                }
            }
        }

        /** 2차원 버블 정렬(sort)  */
        for (int k=0; k <lotto.length; k++) {
            for(int i=lotto[k].length-1; i>0; i--) {
                for(int j=0; j<i; j++) {
                    if(lotto[k][j] > lotto[k][j+1]) {
                        int temp = lotto[k][j];
                        lotto[k][j] = lotto[k][j+1];
                        lotto[k][j+1] = temp;
                    }
                }
            }
        }

        /** 출력, 136 ~ 170이라면 별표 출력*/
        for(int i=0; i<lotto.length; i++) {
            int sum = 0;
            for (int j = 0; j < lotto[i].length; j++) {
                sum += lotto[i][j];
                System.out.print( lotto[i][j] + "\t" );
            }
            if(sum >= 136 && sum <=170) System.out.print( "★★" );
            System.out.println( );
        }
    }
}
