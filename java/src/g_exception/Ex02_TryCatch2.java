package g_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch2 {

    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
        fis = new FileInputStream("abc.txt" );
        System.out.println("파일 연결");
        fis.read();
        }
        catch(FileNotFoundException e) {
            System.out.println("파일없는 예외" + e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println( "입출력 예외" + e.getMessage() );
        }
        catch (Exception e) {
            System.out.println( "그 외 예외 처리" );
        }
        finally {
            try { fis.close(); }
            catch (Exception e) { System.out.println("fis.close error"); }
        }
    }
}
