package c_control;

import java.util.Calendar;

/**
 * 1 - 정수 값 1 (연산 가능) / 4바이트
 * '1' - 문자 1 / 2바이트
 * "1" - 문자열 1 / 위에 것들과 비해 저장 위치가 다름. 힙 메모리에 저장됨.
 */

public class Ex03_주민번호_나이 {
    public static void main(String[] args) {
        String id = "181212-3234567";

        String nai1 = id.substring(0,2);
        int nai2 = Integer.parseInt( nai1 );    // String -> int

        char aa = id.charAt(7);

        int age = 0;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);


        // 주민번호 7번째가 1,2면 1900 | 3,4면 2000
        if (aa == '1'| aa == '2') {
            age = year - (1900+nai2) + 1;
            System.out.println("당신의 나이: " + age );
        }else if(aa == '3' | aa == '4') {
            age = year - (2000+nai2) + 1;
            System.out.println("당신의 나이: " +age );
        }else{
            System.out.println("오류 발생");
        }
    }
}
