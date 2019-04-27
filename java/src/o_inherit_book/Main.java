package o_inherit_book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Item i = null;

        System.out.println( "항목을 선택해주세요. 1.Book / 2.Dvd / 3.Cd" );
        Scanner input = new Scanner( System.in );
        int sel = input.nextInt();

        switch(sel) {
            case 1: i = new Book(); break;
            case 2: i = new Dvd(); break;
            case 3: i = new Cd(); break;
        }
        i.output(); // 하나로 불러보고 싶어서, overriding 시킨 것 ==> 다형성
    }
}
