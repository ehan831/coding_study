package q_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetLotto {
    public static void main(String[] args) {

        HashSet<Integer> lotto = new HashSet<>( );

//        for (int i = 0; i < 6; i++) {
//            int su = (int)(Math.random( ) * 45 + 1);
//            lotto.add( su );
//        } // 중복 숫자가 생기면 결과가 그만큼 준다.

        while (lotto.size( ) < 6) {
            int su = (int) (Math.random( ) * 45 + 1);
            lotto.add( su );
        }

        System.out.println( lotto );
        ArrayList<Integer> list = new ArrayList<>( lotto );
        Collections.sort( list );
        System.out.println( list );
    }
}
