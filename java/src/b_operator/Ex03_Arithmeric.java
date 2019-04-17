package b_operator;

import java.util.Scanner;

/**
 * 산술연산자: * / % , + -
 */

public class Ex03_Arithmeric {
    public static void main(String[] args) {

        // 1. 숫자 하나를 입력 받기 (Scanner -import java.util.Scanner)
        // 2. 홀수인지 짝수인지 연산하여 출력 (% : 나머지 연산자)
        Scanner input = new Scanner( System.in );
        System.out.print("숫자를 입력해주세요: ");
        int num = input.nextInt();

        if (num % 2 == 0) {
            System.out.printf("%d는 짝수입니다",num);

        }else {
            System.out.println("홀수입니다");
        }
    }
}
