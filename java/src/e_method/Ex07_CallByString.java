package e_method;

public class Ex07_CallByString {
    public static void main(String[] args) {

        String a = new String( "행복하자" );
        String b = new String( "아프지말고" );

        add( a, b );

        System.out.println( "2. A = " + a + ", B = " + b );   // 2. A = 행복하자, B = 아프지말고
    }

    static void add(String a, String b) {
        a+=b;
        System.out.println( "1. A = " + a + ", B = " + b );   // 1. A = 행복하자아프지말고, B = 아프지말고
    }
}
