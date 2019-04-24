package f_recursive;

public class Ex02_Factorial {
    public static void main(String[] args) {
        // 5! = 5*4*3*2*1 = 120
        int i = 5;
        int sum = factorial(i);
        System.out.println(sum);
    }

    static int factorial(int i) {
        System.out.println(i);

        if(i==1) return 1;

        return i * factorial(i-1 );
    }
}
