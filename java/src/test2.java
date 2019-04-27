//class test2 {
//    int  i;
//    public  static void main( String [] args ) {
//        System.out.println(“i=”+i);
//    }
//}
//
//class test2 {
//    static  int  i;
//    public  static void main( String [] args ) {
//        System.out.println(“i=”+i);
//    }
//}
//
//class test2 {
//    int  i;
//    public  static void main( String [] args ) {
//        System.out.println(“i=”+Test.i);
//    }
//}
////
//class Var {
//    private  int  i;
//}
//class test2 {
//    int  i;
//    public  static void main( String [] args ) {
//        Var  v = new Var();
//        System.out.println(“i=”+v.i);
//    }
//}

class Parent {

    int  i = 7;

    public int get() {  return i ; }

}

class Child extends Parent {

    int  i = 5 ;

    public int get() {  return i ; }

}

public class test2 {

    public static void main ( String [] args ) {

        Parent  p = new Parent ();

        System.out.println("---------------------1---------------------");

        System.out.println( p.i );

        System.out.println( p.get( ) );

        Child  c = new Child ();

        System.out.println("---------------------2---------------------");

        System.out.println( c.i );

        System.out.println( c.get( ) );

        Parent  p2 = new Child ();

        System.out.println("---------------------3---------------------");

        System.out.println( p2.i );

        System.out.println( p2.get( ) );

    }

}