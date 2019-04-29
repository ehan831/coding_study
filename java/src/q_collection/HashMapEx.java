package q_collection;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
    public static void main(String[] args) {

        HashMap map = new HashMap( );
        map.put( "kim", "1111" );
        map.put( "park", "2222" );
        map.put( "han", "3333" );
        map.put( "lee", "4444" );
        map.put( "bea", "5555" );
        map.put( "na", "6666" );
        map.put( "kim", "9999" );

        Scanner input = new Scanner( System.in );
        boolean stop = false;

        while (!stop) {
            System.out.println( "아이디와 패스워드를 입력해주세요" );
            System.out.println( "아이디 입력 >>" );
            String id = input.nextLine( );
            if (map.containsKey( id )) {
                System.out.println( "패스워드 입력 >>" );
                String pw = input.nextLine( );
                if (map.get( id ).equals( pw )) {
                    System.out.println( "로그인 성공" );
                    stop = true;
                } else {
                    System.out.println( "비밀번호가 일치하지 않습니다" );
                    continue;
                }
            } else {
                System.out.println( "존재하지 않는 아이디 입니다." );
                System.out.println( "==========" );
                continue;
            }
        }
    }
}
