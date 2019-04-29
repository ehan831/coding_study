package z_useful;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today );

        SimpleDateFormat sdf =
                new SimpleDateFormat(" yyyy년 MM월 dd일 E요일 hh:mm:ss");
        System.out.println(sdf.format( today ) );
    }
}
