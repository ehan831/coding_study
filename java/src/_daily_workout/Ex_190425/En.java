package _daily_workout.Ex_190425;

public class En extends Lang {
    En() {
        this( "Hello", "It's Hong Gil-Dong", "Have a good day" );
        System.out.println( "En 기본 생성자" );
    }

    En(String hi, String intro, String comment) {
        this.hi = hi;
        this.intro = intro;
        this.comment = comment;
        System.out.println( "En 인자 생성자" );
    }

    public void output1() {
        System.out.println( hi );
    }

    public void output2() {
        System.out.println( intro );
    }

    public void output3() {
        System.out.println( comment );
    }
}
