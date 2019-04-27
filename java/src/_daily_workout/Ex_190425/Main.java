package _daily_workout.Ex_190425;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        int sel1;
        int sel2;
        char goStop;

        Lang lang = null;

        do {
            while(true) {
                System.out.println( "숫자를 입력하세요. 1.한국어 / 2.영어 / 3.일본어" );
                sel1 = input.nextInt( );
                if (sel1 > 3) {
                    System.out.println( "숫자는 1~3까지 입력 가능합니다." );
                } else break;
            }

            switch (sel1) {
                case 1:
                    lang = new Ko( );
                    break;
                case 2:
                    lang = new En( );
                    break;
                case 3:
                    lang = new Jp( );
                    break;
            }

            while (true) {
                System.out.println( "숫자를 입력하세요. 1.인사말 / 2.자기소개 / 3.하고픈 말" );
                sel2 = input.nextInt( );
                if (sel2 == 1) {
                    lang.output1( );
                    break;
                } else if (sel2 == 2) {
                    lang.output2( );
                    break;
                } else if (sel2 == 3) {
                    lang.output3( );
                    break;
                } else {
                    System.out.println( "숫자는 1~3까지 입력 가능합니다." );
                }
            }
            System.out.println( "다시 하시겠습니까? (Y/N)" );
            goStop = input.next( ).charAt( 0 );
        } while (goStop == 'Y' || goStop == 'y');
    }
}
