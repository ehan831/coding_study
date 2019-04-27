package o_inherit_book;

// 부모 클래스
public abstract class Item {
    String no;
    String title;

    Item() {
        System.out.println( "Item 기본 생성자" );
    }

    Item(String no, String title) {
        this.no = no;
        this.title = title;
        System.out.println( "Item 인자 생성자" );
    }

    public abstract void output();  // abstract 미완성 메소드 입니다. 라는 의미.
}
