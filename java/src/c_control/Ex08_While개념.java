package c_control;

import java.util.StringTokenizer;

public class Ex08_While개념 {
    public static void main(String[] args) {

        /** if */
//        int sum = 0;
//        for (int i = 1; i <= 10; i++) {
//            System.out.println( i );
//            sum = sum + i;
//        }
//        System.out.println( sum );

        /** while */
//        int sum = 0;
//        int i = 1;
//        while(i<=10) {
//            sum+=1;
//            i++;
//        }
//        System.out.println("결과" + sum);

        /** 구구단 만들기 */
//        for(int i = 1; i <=9; i++) {
//            for (int j =1; j<=9; j++) {
//                System.out.print( i + "*" + j + "=" + (i*j) + " ");
//            }
//            System.out.println( );
//        }

        /** while 문으로 구구단 만들기 */
//        System.out.println("원하는 구구단은?");
//        Scanner scan = new Scanner(System.in);
//        int a = scan.nextInt();
//
//        int i = 0;
//        while(i<9) {
//            i++;
//            System.out.println(a +"*" + i + "="+ a*i);

        /** */
//        String str = "독도는 대한민국의 아름다운 섬입니다";
//        StringTokenizer st = new StringTokenizer( str );
//        while (st.hasMoreTokens()) {
//            System.out.println( st.nextToken( ) );
//        }

        /**  */
        String str = "100*3+4/2-5";
        StringTokenizer st =  new StringTokenizer(str, "+-*/%");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
