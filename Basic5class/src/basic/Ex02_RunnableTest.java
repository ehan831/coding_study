package basic;

public class Ex02_RunnableTest {
    public static void main(String[] args) {
//        MakeCar2 mc1 = new MakeCar2( "차를 만들기" );
//        Thread t1 = new Thread( mc1 );
//        t1.start( );
        new Thread( new MakeCar2( "차를 만들기" ) ).start( );


        MakeCar2 mc2 = new MakeCar2( "도색" );
        Thread t2 = new Thread( mc2 );
        t2.start( );

        System.out.println( "프로그램 끝" );
    }
}

class MakeCar2 implements Runnable {
    String work;

    MakeCar2(String _work) {
        work = _work;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println( work + "작업중" );
            try {
                Thread.sleep( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }
}
