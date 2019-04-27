package _daily_workout.Ex_190425;

import java.util.ArrayList;

//public class Test2 {
//    public static void main(String[] args) {
//        ArrayList data = method( );
//
//        for (int i = 0; i < data.size( ); i++) {
//            String str = (String) data.get( i );
//            System.out.println( str );
//        }
//    }
//
//            static ArrayList method () {
//                String a = "올라";
//                String b = "헬로우";
//                String c = "안녕";
//
//                // <String> 같이 쓰는 것을 Generics 라고 한다.
//                ArrayList<String> list = new ArrayList( 3 );
//                list.add( a );
//                list.add( b );
//                list.add( c );
//                list.add( "곤니찌와" );
//                return list;
//            }
//        }
//    }


public class Test2 {

    public static void main(String[] args) {
        ArrayList<String> data = method( );

        for (int i = 0; i < data.size( ); i++) {
            String str = (String) data.get( i ); // get()함수는 자료구조가 string이여도 object형태로 반환하기 때문에 형변환 해줘야함
            System.out.println( str );
        }
        for (String s : data) {
            System.out.println( s );
        }

    }

    static ArrayList<String> method() {    //ArrayList를 사용할 때 <데이터타입>을 지정해주면 String만 처리하고, 처리속도가 빨라짐
        String a = "올라";
        String b = "헬로우";
        String c = "안녕";
        ArrayList<String> list = new ArrayList<String>( 3 );  //일단 기본3개의 index를 만들고 그 이상이면 자동으로 만들어줌
        list.add( a );
        list.add( b );
        list.add( c );
        list.add( "꼰니치와" );
        return list;
    }
}