package a_datatype;

public class Ex02_Caution {
    public static void main(String[] args) {
        // 실수형
//        float f;    // 4 byte
//        f = 3.6F;    // 자바는 기본적으로 8 byte를 잡는다. 그래서 문제가 생김. F를 붙여서 4bype로 잡을 수 있음 > 노추천
        double f;
        f = 3.6;
        System.out.println( "실수:" + f );

        // 문자형 - 정수형
        char ch;
        ch = 65;
        System.out.println( "ch값" + ch );  // 이클립스에서 자동 완성은 control + space, 그리고 syso는 sout

        // int i
        int i = 'a';
        System.out.println( "i값:" + i );  // 아스키코드의 값이 나오넹

        long l = 10000000000L;  // 공간도 8바이트, 숫자도 8바이트라고 선언해주기

        // 형변환
        double db = 100;
        System.out.println( "db값:" + db );

//        int in = 100.1;
//        System.out.println("in값:" + in);    // 작은 공간에 큰 값은 넣을 수 없다.
        int in = (int) 100.1;
        System.out.println( "in값: " + in );

    }
}

