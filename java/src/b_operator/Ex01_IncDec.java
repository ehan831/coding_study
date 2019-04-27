package b_operator;

public class Ex01_IncDec {
    public static void main(String[] args) {
//        int a = 5, b = 7;
//        System.out.println("A=" + (a+1) +", B=" + (b+1) );
//        // A=6,
//
//        a = a + 1;
//        b = b - 1;
//        System.out.println("A=" + a + ", B=" + b );
//
//        a++;
//        b--;
//        System.out.println("A=" + a + ", B=" + b );
//
//        ++a;
//        --b;
//        System.out.println("A=" + a + ", B=" + b );
//
//        // a = a + 1 과 a++과 ++a는 동일하게 작동한다. 단독으로 동작할 시에는 차이가 없는데, 나중에 앞뒤에 무엇인가와 같이 연산괴면 차이가 생길 수 있다.
//
//        int result = ++a;
//        System.out.println("Result: " + result + ", A=" + a);   // 9, 9
//
//        int result2 = a++;
//        System.out.println("Result2: " + result2 + ", A=" + a); // 9, 10
//
//        System.out.println("============================");

        int a = 5, b = 7;
        System.out.println( "A=" + ++a + ", B=" + --b );    // 6, 6
        System.out.println( "A=" + a + ", B=" + b );    // 6, 6
        System.out.println( "A=" + a++ + ", B=" + b-- );    // 6, 6 결과 이후에 연산자가 붙어서 a=7, b=5인 상태이다. 밑에서 확인.
        System.out.println( "A=" + a + ", B=" + b );    // 7, 5
    }
}
