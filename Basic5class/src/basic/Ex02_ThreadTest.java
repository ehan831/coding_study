//package thread.basic;
//
//public class Ex02_ThreadTest {
//    public static void main(String[] args) {
//        MakeCar2 mc1 = new MakeCar2( "차를 만들기" );
////        mc1.run();
//        mc1.start( );
//
//        MakeCar2 mc2 = new MakeCar2( "도색" );
////        mc2.run();
//        mc2.start( );
//
//        System.out.println( "프로그램 끝" );
//    }
//}
//
//class MakeCar1 extends Thread {
//    String work;
//
//    MakeCar1(String _work) {
//        work = _work;
//    }
//
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println( work + "작업중" );
//            try {
//                Thread.sleep( 1000 );
//            } catch (InterruptedException e) {
//                e.printStackTrace( );
//            }
//        }
//    }
//}
