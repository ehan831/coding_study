package c_control;

import java.util.Scanner;

/**
 * -----------------------------------------------------------------------------
 * 문제3 ) 입력받은 문자열의 뒤집어서 출력하세요
 * <p>
 * [예]  입력     출력
 * <p>
 * 안녕 친구   구친 녕안
 * CarpeDiem   meiDepraC
 * -----------------------------------------------------------------------------
 */

public class Ex06_for연습 {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        System.out.println( "문장 입력 --> " );
        String msg = input.nextLine( );
        int length = msg.length( );
        String result = "";
        //for문, charAt()을 사용해서 화면 출력해보자
        for (int i = (length - 1); i >= 0; i--) {
            // System.out.println(i);
            result += msg.charAt( i );
        }
        System.out.println( result );
    }
}




