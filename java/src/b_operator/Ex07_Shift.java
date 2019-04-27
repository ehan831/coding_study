package b_operator;

/**
 * shift : 모든 비트의 값을 이동하는 연산자
 * >> : 오른쪽이동
 * << : 왼쪽이동
 */

public class Ex07_Shift {
    public static void main(String[] args) {
        int a = 4;
        System.out.println( a >> 2 );
        System.out.println( a >>> 2 );
        System.out.println( a << 3 );

        int b = -8;
        System.out.println( b >> 3 );
        System.out.println( b << 2 );    // 음수도 기호 유지됨
    }
}
