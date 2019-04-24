package g_exception;

public class Ex04_Throw {
    public static void main(String[] args) {

        try {
        readArray();
        }catch (Exception ex) {
            System.out.println("예외 발생" + ex.getMessage() );
        }
        System.out.println("정상 종료");
    }

    static void readArray() throws Exception {
        String str[] = {"우리는한배", "공부도 즐기기", "자격증열심히따기"};
        try {
            for (int i = 0; i <= str.length; i++) {
                System.out.println( str[i] );
            }
        }catch (Exception ex) {
            throw new Ex04_MyException();
        }
    }
}
