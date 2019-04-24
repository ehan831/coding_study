package f_recursive;

public class Ex03_Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        int result = fib(n-1);
        System.out.println("결과 : " + result );
    }

    static int fib(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return fib(n-1) + fib(n-2);
    }
    // 34 이 나온다. 9번째!!!!!!
    // 피보나치 수열: 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
}
