package e_method;

public class Ex08_Main {
    /**
     메소드명: main
     인자: String[] args
     리턴형: void

     Test.java ->build-> Test.class
     1. 컴파일: javac Test.java
     2. 실행: java Test
     */
    public static void main(String[] args) {


        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
