package crowling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Hanbit {
    public static void main(String[] args) {

        String url = "http://hanbit.co.kr/media/";
        try {
            Document doc = Jsoup.connect( url ).get( );


            Elements body = doc.select( "div.sub_book_list_area .book_tit > a" );
            for(Element title: body ) {
                System.out.println( title.text() );

            }



        } catch (IOException e) {
            e.printStackTrace( );
        }
    }
}
