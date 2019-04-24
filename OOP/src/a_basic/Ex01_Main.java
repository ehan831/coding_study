package a_basic;

public class Ex01_Main {
    public static void main(String[] args) {
        Ex01_Student s = new Ex01_Student();
        s.setName( "홍길동" );
        s.setKor( 100 );
        s.setEng( 88 );
        s.setMath( 77 );
        System.out.println( "총점: " + s.calTotal());
        System.out.println( "평균: " + s.calAverage( ) );
    }
}
