package o_inherit_book;

// 자식클래스
public class Book extends Item {

    String writer;
    String publisher;

    Book() {
        super();    // 생략 가능
        System.out.println( "Book 기본 생성자" );
    }

    Book(String no, String title, String writer, String publisher) {
//        super();  // 자동으로 입력되는 부분, 입력은 생략가능
        super.no = no;  // 내 멤버는 this, 부모 멤버는 super 로 접근해줘야 한다. 이론적으로는.
        super.title = title;
        this.writer = writer;
        this.publisher = publisher;
        System.out.println( "Book 인자 생성자" );
    }

    public void output() {
        System.out.println( "등록 번호: " + no );
        System.out.println( "등록 제목: " + title );
        System.out.println( "글쓴이: " + writer );
        System.out.println( "출판사: " + publisher );
    }
}
