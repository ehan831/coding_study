package k_static;

public class Main {
    public static void main(String[] args) {
//        Book b1 = new Book();
//        Book b2 = new Book();
//        Book b3 = new Book();
//
//        System.out.println("갯수: " + b3.count);

        System.out.println("갯수: " + Book.count);    // static 은 객체가 없이도 클래스명으로 접근이 가능하다.
        System.out.println("갯수: " + Book.getCount());    //
    }
}
