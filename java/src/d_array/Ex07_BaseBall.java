package d_array;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex07_BaseBall {
    public static void main(String[] args) {
        int[] baseball_answer = new int[3];

        /** 1. 컴퓨터 랜덤 수 3개 만들기 */
        Random ran_num = new Random( );
        for (int i = 0; i < baseball_answer.length; i++) {
            baseball_answer[i] = ran_num.nextInt( 10 );     // 0~9 숫자 랜덤으로 받기
            for (int j = 0; j < i; j++) {
                if (baseball_answer[i] == baseball_answer[j]) {     // 기존의 숫자와 중복이 있는지, 있다면 다시 뽑기
                    i--;
                }
            }
        }

        for (int i = 0; i < baseball_answer.length; i++) {      // 확인하기 위해 뽑힌 숫자를 보기
            System.out.print( baseball_answer[i] + "\t");
        }

        /** 2. 사용자가 입력값을 담을 answer 에 각각 담기 */

        int[] baseball_input = new int[3];
        Scanner input = new Scanner( System.in );

        for (int n = 0; n < 10; n++) {      // 10번의 기회를 주기로

            System.out.println( );
            System.out.println( "숫자 3개를 입력해주세요(0~9) ex.0/1/2" );
            String input_num = input.nextLine( );       // 숫자 3개 입력 받기 ex. 0/1/2

            StringTokenizer st = new StringTokenizer( input_num, "/" );

            for (int i = 0; st.hasMoreTokens( ); i++) {     // 받은 숫자를 하나 하나 찢어보자
                baseball_input[i] = Integer.parseInt( st.nextToken( ) );
            }


            /** 3. baseball 배열과 answer 배열을 비교 */
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < baseball_answer.length; i++) {
                for (int j = 0; j < baseball_input.length; j++) {
                    if (baseball_answer[i] == baseball_input[i]) {      // 값과 위치가 동일하면 스트라이크
                        strike += 1;
                        break;
                    } else if (baseball_answer[i] == baseball_input[j]) {       // 값만 일치, 위치가 불일치 하면 볼
                        ball += 1;
                    } else {
                    }
                }
            }
            if (strike != 3) {      // 3 스트라이크면 끝내자
                System.out.println( strike + "스트라이크" + ball + "볼" );
            } else {
                System.out.println("정답입니다. 축하드려요");
                break;
            }
        }
    }
}