package k_static;

public class Book {
//    int count;
    static int count;   // static을 붙이면 main의 카운트가 누적되어 나온다.
    // static = 각 객체에서 공유하기 위해 사용됨. 자신의 메모리 공간을 따로 할당받는거임.

    public Book() {
        count++;
        System.out.println("책 한권 생성");
    }

    public static int getCount() {  // static 이 꼭 붙어야한다.
        return count;
    }
}
