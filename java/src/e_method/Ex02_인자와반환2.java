package e_method;

public class Ex02_인자와반환2 {
    public static void main(String[] args) {
        int sum = add();
        System.out.println("합: " + sum);
    }

    static int add() {     // void = 아무 값도 반환하지 않을거야
        int a = 10, b = 20;
        int sum = a + b;
        return sum;
    }   // return은 흐름을 반환, 호출한 곳으로 1개의 값만을 반환
}
