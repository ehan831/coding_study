package q_collection;

import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {

        TreeSet set = new TreeSet( );
        set.add( "lion" );
        set.add( "tiger" );
        set.add( "snake" );
        set.add( "cobra" );
        set.add( "dog" );
        set.add( "cat" );
        set.add( "bee" );
        set.add( "zebra" );
        set.add( "lion king" );

        System.out.println( set );
        System.out.println( set.subSet( "d", "s" ) );
        System.out.println( set.headSet( "d" ) );
        System.out.println( set.tailSet( "d" ) );
    }
}
