package _daily_workout.Ex_190426;

public class CompactDisc extends Product {

    String title;
    String singer;

    CompactDisc(int productID,  String description, String producer, int price, String title, String singer) {
        super( );
        System.out.println( "CD 인자 생성자" );
    }
}
