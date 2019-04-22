package e_method;

//public class Ex05_overloading {
//    public static void main(String[] args) {
//        int a = 5, b = 7;
//        addInt(a,b);
//
//        int c = 3;
//        double d = 3.6;
//        addIntDouble(c,d);
//    }
//
//    static void addInt(int a, int b) {
//        System.out.println(a+b);
//    }
//
//    static void addIntDouble(int c, double d) {
//        System.out.println(c+d);
//    }
//}

public class Ex05_overloading {
    // overloading, 동일한 이름의 메소드들 - 인자의 자료형과 개수로 구분한다.
    // 메소드 이름이 같아도 되네?! 인자의 자료형으로 비교가 된다.

    // 주의할 점 add(1,2)
    // int add(int a, int b) {}
    // double add(int a, int b) {}
    // 리턴형만 다르면 컴파일 오류 발생 !!

    public static void main(String[] args) {
        int a = 5, b = 7;
        add(a,b);

        int c = 3;
        double d = 3.6;
        add(c,d);
    }

    static void add(int a, int b) {
        System.out.println(a+b);
    }

    static void add(int c, double d) {
        System.out.println(c+d);
    }
}

