package e_method;

public class Ex07_CallByValue {
    public static void main(String[] args) {
        int a = 10, b = 20;
        add(a,b);
        System.out.println("2. A = " + a + ",B = " + b ); // 10, 20
    }
    static void add(int a, int b) {
        a+=b;
        System.out.println("1. A = " + a + ",B = " + b ); // 30, 20
    }
}
