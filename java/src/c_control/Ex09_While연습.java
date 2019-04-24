package c_control;

/**-----------------------------------------------------
 3! 6! 9! 게임
    1 ~ 50 까지의 숫자 중에서 3,6,9가 포함되면 그 갯수만큼 '짝' 출력
    하나도 포함되지 않았으면 해당 숫자 출력
 -----------------------------------------------------*/
//public class Ex09_While연습 {
//    public static void main(String[] args) {
//        for(int i = 1; i<=50; i++) {
//            int mok = i;
//            boolean su369 = false;
//
//            while(mok!=0) {
//                int na = mok%10;
//                if(na==3|na==6|na==9) {
//                    System.out.print("짝");
//                    su369 = true;
//                }
//                mok /= 10;
//            }
//
//            if(su369) {
//             System.out.println( );
//            }else {
//                System.out.println(i);
//            }
//        }
//    }
//}

    /**
     * -----------------------------------------------------
     * 문제  : 8의 숫자 세기(구글입사문제)
     * <p>
     * 1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
     * 8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
     * (※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 합니다)   결과 : 4000
     * -----------------------------------------------------*/
//public class Ex09_While연습 {
//    public static void main(String[] args) {
//        int sum = 0;
//        for(int i=1; i<=10000 ; i++) {
//            int mok=i;
//            boolean yorn = false;
//
//            while(mok!=0) {
//                int na= mok%10;
//                if(na==8) {
//                    sum+=1;
//                    yorn = true;
//                }
//                mok/=10;
//            }
//        }
//        System.out.println(sum);
//    }
//}
