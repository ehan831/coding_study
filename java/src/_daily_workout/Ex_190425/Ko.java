package _daily_workout.Ex_190425;

public class Ko extends Lang {
    Ko() {
        this( "안녕하세요", "홍길동입니다", "오늘도 좋은 하루" );
        System.out.println( "Ko 기본 생성자" );
    }

    Ko(String hi, String intro, String comment) {
        this.hi = hi;
        this.intro = intro;
        this.comment = comment;
        System.out.println( "Ko 인자 생성자" );
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
