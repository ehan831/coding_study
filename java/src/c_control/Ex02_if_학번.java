package c_control;

public class Ex02_if_학번 {
    public static void main(String[] args) {
        String hakbun = "2017111001";
        char dan = hakbun.charAt( 4 );
        String dande = "";
        String hakyeon = hakbun.substring( 0, 4 );
        String hak = hakbun.substring( 5, 7 );
        String hakgwa = "";
        System.out.println( dan + hak );

        if (dan == '1') {
            dande = "공대";
            if (hak.equals( "11" )) {
                hakgwa = "컴퓨터학과";
            } else if (hak.equals( "12" )) {
                hakgwa = "소프트웨어학과";
            } else if (hak.equals( "13" )) {
                hakgwa = "모바일학과";
            } else if (hak.equals( "22" )) {
                hakgwa = "자바학과";
            } else if (hak.equals( "33" )) {
                hakgwa = "서버학과";
            } else {
                System.out.println( "문제 발생" );
            }
        } else if (dan == '2') {
            dande = "사회대";
            if (hak.equals( "11" )) {
                hakgwa = "사회학과";
            } else if (hak.equals( "12" )) {
                hakgwa = "경영학과";
            } else if (hak.equals( "13" )) {
                hakgwa = "경제학과";
            } else {
                System.out.println( "문제 발생" );
            }
        }
        System.out.printf( "%s는 %s년에 입학한 %s %s 학생입니다", hakbun, hakyeon, dande, hakgwa );
    }
}
