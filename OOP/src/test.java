// 에러가 나게 만들어보자 java.lang.ArithmeticException: / by zero
//public class test {
//
//    static void errorrrr() {
//        int a  = 4/0;
//    }
//
//    public static void main(String[] args) {
//        errorrrr();
//    }
//}


//// errorrrr에서 예외 처리해보기
//public class test {
//
//    static void errorrrr() {
//        try {
//            int a = 4/0;
//        }catch (Exception ex) {
//            System.out.println( ex.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        errorrrr();
//    }
//}

//// errorrrr에서 예외를 main으로 던지기 하자 // main에 미구현해보기
//public class test {
//
//    static void errorrrr() throws Exception{
//       int a = 4/0;
//    }
//
//    public static void main(String[] args) {
//        errorrrr();
//    }
//}

// errorrrr에서 예외를 main으로 던지기 하자 // 잘됨
public class test {

    static void errorrrr() throws Exception{
        int a = 4/0;
    }

    public static void main(String[] args) {
        try {
            errorrrr( );
        }catch (Exception ex) {
            System.out.println( ex.getMessage() );
        }
    }
}


//
//    static int a=10, b=0;
//
//    static int divide() {
//        return a/b;
//    }
//
//    public static void main(String[] args) {
//        try {
//            System.out.println( divide() + "잘 되는것인가" );
//        }catch (Exception ex) {
//            System.out.println( "에러 발생" + ex.getMessage() );
//        }
//    }
//}
