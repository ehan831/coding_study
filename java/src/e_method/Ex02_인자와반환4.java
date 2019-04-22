package e_method;

public class Ex02_인자와반환4 {

    static int a, b;   // 멤버 변수(다른 곳에서는 전역 변수의 개념)
    static int sum;    // 밖으로 뺐더니 어디에서나 접근 가능한 변수가 되네

    public static void main(String[] args) {
        a=10; b=20;
        add();

        System.out.println("합: " + sum );
    }
    static void add() {
        sum = a + b;
    }
}
