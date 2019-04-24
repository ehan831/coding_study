/**-----------------------------------------------------
 * 숫자를 3개 받아서 그 중에 2번째로 큰 수를 출력하자
 -----------------------------------------------------*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex_190415 {
    public static void main(String[] args) {    // 숫자 3개 받기
        Scanner input = new Scanner(System.in);
        System.out.print("1번 숫자=>");
        int a = input.nextInt();
        System.out.print("2번 숫자=>");
        int b = input.nextInt();
        System.out.print("3번 숫자=>");
        int c = input.nextInt();

        final List<Integer> ranks = new ArrayList<>();  // 받은 숫자로 리스트 만들기
        ranks.add(a);
        ranks.add(b);
        ranks.add(c);
        System.out.println(ranks);

        Collections.sort(ranks);    // 정렬하기
        System.out.println(ranks);

        System.out.print(ranks.get(1)); // 2번째 숫자 뽑기
        }
    }
