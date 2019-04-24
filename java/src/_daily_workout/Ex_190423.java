package _daily_workout;

public class Ex_190423 {
    public static void main(String[] args) {
        int n = 4;
        f(n);        System.out.println("======");
        g(n);        System.out.println("======");
        h(n);        System.out.println("======");
        t(n);        System.out.println("======");
    }
    // f(4)를 호출한다면? 4 3 2 1 0
    public static void f ( int N ) {
        System.out.println(N);
        if( N > 0 ) f ( N-1);
    }


    // g(4)를 호출한다면? 0 1 2 3 4
    public static void g ( int N) {
        if( N > 0 ) g( N-1);
        System.out.println(N);
    }

    // h(4)를 호출한다면? 4 2 0 0 2 4
    public static void h ( int N ) {
        System.out.println(N);
        if( N > 0 ) h ( N -2 );
        System.out.println(N);
    }
    // t(4)를 호출한다면? 0 1 0 0
    // 2진수 만드는 방법이드아!!!!!!
    public static void t ( int N ) {
        if( N > 0 ) t ( N/2);
        System.out.println( N % 2);
    }
}
