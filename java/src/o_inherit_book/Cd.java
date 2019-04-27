package o_inherit_book;

public class Cd extends Item{
    String singer;

    Cd() {
        System.out.println( "Cd 기본 생성자" );
    }

    Cd(String no, String title, String singer) {
        super.no = no;
        super.title=title;
        this.singer=singer;
        System.out.println( "Cd 인자 생성자" );
    }

    public void output() {
        System.out.println( "등록 번호" + no );
        System.out.println( "등록명" + title );
        System.out.println( "가수명" + singer );
        System.out.println( "Cd 인자 생성자" );
    }

}
