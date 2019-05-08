package basic;

public class Ex5_ThreadStop {
    public static void main(String[] args) {

        System.out.println( "메인쓰레드" + Thread.currentThread( ).getName( ) );
        MakeCar3 mc = new MakeCar3( );
        mc.start( );
        try {
            Thread.sleep( 2000 );
        } catch (Exception ex) {
            ex.printStackTrace( );
        }
        System.out.println( "쓰레드 종료" );
        mc.flag = true;
    }
//        mc.stop();  // 사용을 권장하지 않음. 에러를 만들어서 종료시키는 구조 // stop 하면 다시 start 해도 안됨??
}


class MakeCar3 extends Thread {

    boolean flag = false;

    public void run() {
        for (int i = 0; i < 50; i++) {
            if (flag) return;
            System.out.println( getName( ) + "작업중" );
            try {
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace( );
//            } catch (ThreadDeath e) {
//                System.out.println("쓰레드 강제 종료됨" + toString() );
//            }
            }
        }
    }
}