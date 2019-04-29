package z_useful;

import java.util.Arrays;

public class CloneEx {
    public static void main(String[] args) {

        String[] array = {"안녕", "헬로우", "올라", "곤니치와"};
//        String[] copy = array;  // 얇은 복사, 메모리 주소만 딸랑 복사
        String[] copy = array.clone();  // 깊은 복사

        System.out.println( Arrays.toString( array ) );
        System.out.println( Arrays.toString( copy ) );

        copy[1] = "Hello";
        copy[2] = "Hola";

        // 얇은 복사 시에는 copy 를 변경하면 원본도 변경된다. 깊은 복사 시에는 copy 를 변경해도, 원본은 그대로이다.
        System.out.println( Arrays.toString( array ) );
        System.out.println( Arrays.toString( copy ) );
    }
}
