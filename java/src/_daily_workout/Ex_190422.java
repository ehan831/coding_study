package _daily_workout;

import java.util.Scanner;

public class Ex_190422 {
    public static void main(String[] args) {
        /**-----------------------------------------------------
        (문제 1) 영문자를 입력하여 이 문자가 소문자이면 true 을 반환 그렇지 않으면 false 을 반환하는 메소드를 작성하시오.
         함수명 : checkLower
         인자 : char
         리턴(반환) : boolean
         -----------------------------------------------------*/
        Scanner input = new Scanner( System.in );
        System.out.println("문자를 입력해주세요");
        char ch = input.next().charAt(0);
        boolean result = checkLower(ch);
        System.out.println(result);
    }

    static boolean checkLower(char ch) {
        if(Character.isLowerCase(ch)) {
            return true;
        }else return false;
    }
}

// test test test test