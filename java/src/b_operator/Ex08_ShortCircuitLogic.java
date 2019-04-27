package b_operator;

/**
 * 숏서킷로직 : 일반 논리에 적용
 */

public class Ex08_ShortCircuitLogic {
    public static void main(String[] args) {
//        int a = 3;
//        if ( a>3 && ++a>3 ) {
//            System.out.println("조건만족");    // 출력여부
//        }
//        System.out.println("A=" + a);    // a값
//        // false, 4가 되어야 하는데, 실제로는 false, 3이 나옴
//        // 왜냐 and(&&)에서는 앞 조건이 false면 뒤에건 그냥 pass해버림. 그래서 ++a가 반영이 안된 것 = 숏서킷로직
//
//        if( a>1 || ++a>3 ) {
//            System.out.println("조건만족2");
//        }
//        System.out.println("A=" + a);
//        // or(||) 조건에서 앞에가 true이니까, 결과는 true네!? 뒤에건 생각도 안하고 pass 해버림. 그래서 ++a가 반영이 안됨
//
//        if( a>4 || ++a>3 ) {
//            System.out.println("조건만족3");
//        }
//        System.out.println("A=" + a);   // 이제서야 ++a가 수행되었다.

        // 저런 문제가 있다. 뭐야 너무 머리아프자나. 그래서 다음과 같은 걸 제공해줌
        // 원래 일반 논리에는 &&, || 를 써야하는데!! 이진 논리 연산자를 쓰면 다음과 같이 수행된다.

        int a = 3;
        if (a > 3 & ++a > 3) {
            System.out.println( "조건만족" );    // 출력여부
        }
        System.out.println( "A=" + a );    // a값
        // false, 4가 되어야 하는데, 실제로는 false, 3이 나옴
        // 왜냐 and(&&)에서는 앞 조건이 false면 뒤에건 그냥 pass해버림. 그래서 ++a가 반영이 안된 것 = 숏서킷로직

        if (a > 1 | ++a > 3) {
            System.out.println( "조건만족2" );
        }
        System.out.println( "A=" + a );
        // or(||) 조건에서 앞에가 true이니까, 결과는 true네!? 뒤에건 생각도 안하고 pass 해버림. 그래서 ++a가 반영이 안됨

        if (a > 4 | ++a > 3) {
            System.out.println( "조건만족3" );
        }
        System.out.println( "A=" + a );   // 이제서야 ++a가 수행되었다.
    }
}

