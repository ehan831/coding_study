package b_operator;

import java.util.Scanner;

/**
 * 논리연산자
 *  - 일반논리 (true/false): && ||
 *  - 이진논리 (bit에 있는 1,0): & | ^
 */

public class Ex05_GeneralLogical {
    public static void main(String[] args) {
        int 성적 = 75;
        char 태도 = 'A';

        // 성적향상반의 조건 - 성적 80점 이상 and 태도는 A 이여야함
        // 우등생의 조건 - 성적 80점 이상 or 태도는 A이면 가능
        if (성적 >= 80 && 태도 == 'A') {
            System.out.println("성적향상반 가능");
        }else if(성적 >=80 || 태도 == 'A') {
            System.out.println("우등생 가능");
        }else {
            System.out.println("아무것도 아님");
        }

        Scanner input = new Scanner( System.in );
        System.out.println("문자 하나만 입력해주세요");
//        String ch = input.next();
        char ch = input.next().charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println("대문자 입니다.");
        }else {
            System.out.println("대문자가 아닙니다");
        }
    }
}
