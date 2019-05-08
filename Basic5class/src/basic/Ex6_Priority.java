package basic;

public class Ex6_Priority {
    public static void main(String[] args) {
//        MakeCar4 mc1 = new MakeCar4( "차틀", Thread.MAX_PRIORITY );
        MakeCar4 mc1 = new MakeCar4( "차틀", Thread.NORM_PRIORITY);
        mc1.start();

        MakeCar4 mc2 = new MakeCar4( "도색", Thread.MIN_PRIORITY);
        mc2.start();

        // 자바 내에서 우선 순위를 아무리 줘도, 운영체제 내에서 이를 제대로 반영되지 않는다 ?!
        // 운영체제는 RR (Round Robin) 방식을 채택하고 있음 ?!
    }
}


class MakeCar4 extends Thread {
    String work;

    MakeCar4(String _work, int prio) {
        work = _work;
        setPriority( prio );
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