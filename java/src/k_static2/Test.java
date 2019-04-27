package k_static2;

public class Test {
    public static void main(String[] args) {
        UserA a = new UserA();  // 클래스 a = new 생성자 메소드
        a.use();

        UserB b = new UserB();
        b.use();

        UserC c = new UserC();
        c.use();
    }
}
