package c_control;

public class Ex01_if_주민번호 {
    public static void main(String[] args) {
        String id = "800101-1234567";
        char sung = id.charAt( 7 );
        System.out.println( sung );
        // 1,3,9이면 남자를 출력 // 2,4,8이면 여자를 출력
        if (sung == '1' | sung == '3' | sung == '9') {
            System.out.println( "남자입니다" );
        } else if (sung == '2' | sung == '4' | sung == '8') {
            System.out.println( "여자입니다." );
        } else {
            System.out.println( "성별을 알 수 없습니다" );
        }
    }
}
