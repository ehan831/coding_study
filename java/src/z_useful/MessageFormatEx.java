package z_useful;

import java.text.MessageFormat;

public class MessageFormatEx {
    public static void main(String[] args) {

        String message = "친애하는 <{0}> {1}, 본문본문 생략..... 감사합니다";

        String[][] data = {
                {"홍길동", "부장님"},
                {"홍길자", "과장님"},
                {"홍길숙", "대림님"},
                {"홍길순", "사원님"}
        };
        for (int i = 0; i < data.length; i++) {
            System.out.println( MessageFormat.format( message, data[i] ) );
        }
    }
}
