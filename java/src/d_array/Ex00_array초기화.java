package d_array;

public class Ex00_array초기화 {
    public static void main(String[] args) {

        int a; // 변수 선언(기본형) -> 메모리 확보
        a = 10; // 값지정
        int b = 20; // 초기화

        /**
         int[] arr; // 변수 선언(참조형) -> 메모리 확보 X
         arr = new int[3];
         arr[0]=10;
         arr[1]=19;
         arr[2]=33;
         */

        int[] arr = new int[]{10, 19, 33};
        int[] arr2 = {10, 19, 33}; // 생략해서 표현 가능

        for (int i = 0; i < arr.length; i++) {
            System.out.println( i );
        }

    }
}
