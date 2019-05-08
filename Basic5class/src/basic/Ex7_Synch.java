package basic;

class Count {
    int i;

    void increment() {
        synchronized(this) {  // synchronized : 작업 중이면 lock //
            i++;
        }
        /* 풀어서 쓰면
        * 1) read i
        * 2) i + 1
        * 3) write i
        * */
    }
}

class ThreadCount extends Thread {
    Count cnt;

    public ThreadCount(Count cnt) {
        this.cnt = cnt;
    }

    public void run() {
        for (int i = 0; i < 10000000; i++) {
            cnt.increment( );
        }
    }
}

public class Ex7_Synch {
    public static void main(String[] args) {
        Count cnt = new Count( );

        ThreadCount tc1 = new ThreadCount( cnt );
        tc1.start( );

        ThreadCount tc2 = new ThreadCount( cnt );
        tc2.start( );

        try {
            tc1.join( );
        } catch (InterruptedException e) {
            System.out.println( "tc1 error" );
            e.printStackTrace( );
        }
        try {
            tc2.join( );
        } catch (InterruptedException e) {
            System.out.println( "tc2 error" );
            e.printStackTrace( );
        }

        System.out.println( "i값 : " + cnt.i );
    }
}
