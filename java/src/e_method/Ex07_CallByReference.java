package e_method;

public class Ex07_CallByReference {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("행복하자");
        StringBuffer b = new StringBuffer("아프지말고");

        add(a, b);

        System.out.println("2. A = " + a + ", B = " + b);   // 2. A = 행복하자아프지말고, B = 아프지말고
    }
    static void add(StringBuffer a, StringBuffer b) {
        a.append(b);
        System.out.println("1. A = " + a + ", B = " + b);   // 1. A = 행복하자아프지말고, B = 아프지말고
    }
}