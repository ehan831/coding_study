package b_operator;

/**
 * 대입연산자 : =
 *  - 축약 대입연산자 ( 산술 / 이진 / 쉬프트 )
 */

public class Ex10_Assignment {
    public static void main(String[] args) {
        int a=50, b=7;
        // a = a+b;
        a+=b;   // 위에 것을 축약함
        System.out.println("A=" + a);   //57
        a-=b;
        System.out.println("A=" + a);   //50
        a*=b;
        System.out.println("A=" + a);   //350
        a%=b;
        System.out.println("A=" + a);   //0
        a/=b;
        System.out.println("A=" + a);   //0
    }
}
