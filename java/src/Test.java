//class Test {
//    public static void main ( String  [] args ) {
////        int a = 10-7^3+1*2&4;
////        System.out.println(a);
//
//        // 변수
//        double x = 2.5;
//        int y = 5;
//        System.out.println( x + y );
//    }
//}

//public class Test{
//    public static void main( String [] args ) {
//        int i = 0, j = 0;
//        for( i = 0 ; i < 5 ; i++ ) {
//            for( j = 0 ; j < 4 ; j++ ) {
//                if( i == 2 && j == 1 ) break;
//                if( i == 3 && j == 2 ) continue;
//            }
//        }
//        System.out.println("i = " + i + " , j = " +  j );
//    }
//}


class Test{
    public static void main( String [] args ) {
        int i = 1, j = 10;
        do {
            if(  i > j ) break;
            j--;
        } while( ++i < 5 );
        System.out.println("i = " + i + " , j = " +  j );
    }
}