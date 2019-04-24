package g_exception;

/**
 오류
    - 에러: 심각한 오류, 시스템 레벨에서 발생하여, 개발자가 어떻게 할 수가 없는 수준
    - 예외: 개발자가 구현한 로직에서 발생함

 예외처리가 필요한 이유 - 프로그램을 정상적으로 종료시키기 위해서

 1. try {의도한 구문}
 2. catch {예외 발생 시 구문}
 3. finally {예외 발생 여부와 상관없이 무조건 실행하는 구문}
 */

public class Ex01_TryCatch {
    public static void main(String[] args) {

        String[] str = {"맛점", "우산", "즐거운화요일"};

        try {
            for (int i = 0; i <= str.length; i++) {
                System.out.println( str[i] );
            }
            System.out.println("의도한 구문");
            return; // 리턴이 있어도 finally는 수행한다. !!!!
        } catch (Exception ex) {
            System.out.println("=============");
            System.out.println( "예외발생" + ex.getMessage( ) );
            System.out.println( "예외발생" + ex.toString( ) );
            ex.printStackTrace();
            System.out.println("=============");
        }
        finally {
            System.out.println("무조건 실행하는 구문");
        }
        System.out.println( "프로그램 종료" );
    }
}
