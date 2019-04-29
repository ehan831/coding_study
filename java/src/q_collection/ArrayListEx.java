package q_collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1. List
 * 순서가 유지되는 collection
 *
 *
 **/

public class ArrayListEx {
    public static void main(String[] args) {
//
//        ArrayList list = new ArrayList(4);
//        list.add("rabbit");
//        list.add("tiger");
//        list.add("lion");
//        list.add("cat");
//        list.add("ant");
//        list.add("cobra");
//
//        for (int i = 0; i <list.size(); i++) {
//            String str = (String)list.get(i);
//        }
//    }


        // generics 라는 것. String 만 받겟다고 해야 향상된 for 문을 사용할 수 있다.
        ArrayList<String> list = new ArrayList( 4 );
        list.add( "rabbit" );
        list.add( "tiger" );
        list.add( "lion" );
        list.add( "cat" );
        list.add( "ant" );
        list.add( "cobra" );

        for (String str : list) {
            System.out.print( str + "\t" );
        }
        System.out.println( );

        list.set( 2, "dog" );
        for (String str : list) {
            System.out.print( str + "\t" );
        }
        System.out.println( );

        list.remove( 4 );
        for (String str : list) {
            System.out.print( str + "\t" );
        }
        System.out.println( );

        Collections.sort( list );
        for (String str : list) {
            System.out.print( str + "\t" );
        }
        System.out.println( );
    }
}
