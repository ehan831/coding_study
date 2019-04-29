package z_useful;

//class Size {
//    public final static int small = 100;
//    public final static int medium = 200;
//    public final static int large = 300;
//}

enum Size {
    SMALL,
    MEDIUM,
    LARGE
}

public class EnumTest {
    public static void main(String[] args) {
        Size size = Size.SMALL; // 추후에 화면에서 넘어오는

        switch (size) {
            case SMALL:
                System.out.println( "작은거" );
            case MEDIUM:
                System.out.println( "중간거" );
            case LARGE:
                System.out.println( "큰거" );
        }
    }
}
