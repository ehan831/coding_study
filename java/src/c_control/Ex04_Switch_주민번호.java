package c_control;

/**
 * Switch 문 : 분기문
 *
 * switch(____)        << 여기에는 정수형/문자형/String(스트링은 1.5이상부터 가능)
 * {
 *     case A: 명령어 A; break;
 *     case B: 명령어 B; break;
 *     ...
 *     default: 그외 명령어 //맨 뒤에 있어서 break 생략한거임. 위에 있으면 넣어야함.
 * }
 */

public class Ex04_Switch_주민번호 {
    public static void main(String[] args) {
        String id = "851212-1234567";
        char state = id.charAt( 8 );
        String home = "";

        switch (state) {
            case '0': home="서울"; break;
            case '1': home="인천/부산"; break;
            case '2': home="경기"; break;
            case '9': home="제주"; break;
            default: home="해당 없음";
        }
        System.out.println("출신지: " + home);
    }
}

