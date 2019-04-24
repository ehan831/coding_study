package i_class_array;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Student[] s = new Student[3];

        Scanner input = new Scanner(System.in);

        for(int i=0; i<s.length; i++) {
            s[i] = new Student();  // 위에서는 배열만 메모리 할당 받은 것? 객체도 할당 받아야 한다.

            System.out.println("학생명입력 : ");
            s[i].setName(input.next());
            System.out.println("국어점수 : ");
            s[i].setKor(input.nextInt());
            System.out.println("영어점수 : ");
            s[i].setEng(input.nextInt());
            System.out.println("수학점수 : ");
            s[i].setMath(input.nextInt());

            s[i].cal_Total();
            s[i].cal_Average();

            System.out.println(s[i]);
        }
    }
}