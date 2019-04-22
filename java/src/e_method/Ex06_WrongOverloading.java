package e_method;

public class Ex06_WrongOverloading {
    public static void main(String[] args) {
        String msg = "안녕";
        output1(msg);
        String result = output2(msg);
        System.out.println(result);
    }

    static void output1(String msg) {
        System.out.println(msg);
    }

    static String output2(String msg) {
        String result = "맞점-" + msg;
        return result;
    }
}
