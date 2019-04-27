package j_constructor;

public class Ex01_Main {
    public static void main(String[] args) {

        Ex01_Student s = new Ex01_Student( "홍길동", 100, 90, 80 );
        System.out.println( "이름: " + s.getName( ) );
        System.out.println( "총점: " + s.cal_Total( ) );
        System.out.println( "평균: " + s.cal_Average( ) );
        System.out.println( s.toString( ) );

        System.out.println( "=============" );

        Ex01_Student ss = new Ex01_Student( );
        System.out.println( "이름) " + ss.getName( ) );
        System.out.println( "총점) " + ss.cal_Total( ) );
        System.out.println( "평균) " + ss.cal_Average( ) );
        System.out.println( ss.toString( ) );
    }
}
