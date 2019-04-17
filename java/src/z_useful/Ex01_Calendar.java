package z_useful;

import java.util.Calendar;

public class Ex01_Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "년");
        System.out.println((c.get(Calendar.MONTH)+1) + "월");
        System.out.println(c.get(Calendar.DATE) + "일");

        // 시, 분, 초 얻가
        System.out.println(c.get(Calendar.HOUR) + "시");
        System.out.println(c.get(Calendar.MINUTE) + "분");
        System.out.println(c.get(Calendar.SECOND) + "초");

        // 요일
        System.out.println(c.get(Calendar.DAY_OF_WEEK) + "요일");

        // 그 외 정보
        System.out.println("그 해의" + c.get(Calendar.DAY_OF_YEAR) + "일입니다.");
        // WEEK_OF_YEAR, WEEK_OF_MONTH
    }
}
