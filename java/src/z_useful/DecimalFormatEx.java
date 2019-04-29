package z_useful;

import java.text.DecimalFormat;

public class DecimalFormatEx {
    public static void main(String[] args) {


        double[] date = {1234567, 55555.123, 99.999999999, 1234.50};

        DecimalFormat df = new DecimalFormat( "###,###,###.##########" );

        for (int i = 0; i < date.length; i++) {
            System.out.println( df.format( date[i] ) );
        }
    }
}
