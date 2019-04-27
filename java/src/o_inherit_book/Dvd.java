package o_inherit_book;

public class Dvd extends Item {
    String actor;
    String director;

    Dvd() {
        super();    // 생략 가능
        System.out.println( "Dvd 기본 생성자" );
    }

    Dvd(String no, String title, String actor, String director) {
        super.no = no;  // 내 멤버는 this, 부모 멤버는 super 로 접근해줘야 한다. 이론적으로는.
        super.title = title;
        this.actor = actor;
        this.director = director;
        System.out.println( "Dvd 인자 생성자" );
    }

    public void output() {
        System.out.println( "등록 번호: " + no );
        System.out.println( "등록 제목: " + title );
        System.out.println( "배우: " + actor );
        System.out.println( "감독: " + director );
    }
}
