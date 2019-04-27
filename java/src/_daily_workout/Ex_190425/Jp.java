package _daily_workout.Ex_190425;

public class Jp extends Lang {
    Jp() {
        this( "おはようございます", "ホンギルドンです", "よいついたちを" );
        System.out.println( "Jp 기본 생성자" );
    }

    Jp(String hi, String intro, String comment) {
        this.hi = hi;
        this.intro = intro;
        this.comment = comment;
        System.out.println( "Jp 인자 생성자" );
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
