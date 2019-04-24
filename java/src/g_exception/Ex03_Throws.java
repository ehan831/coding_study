package g_exception;

import java.io.FileInputStream;

public class Ex03_Throws {
    public static void main(String[] args) {
        try {
            readFile( );
            System.out.println( "파일 처리" );
        }catch (Exception e) {
            System.out.println( "예외 발생" );
        }
    }

    static void readFile() throws Exception{
        FileInputStream fis = new FileInputStream( "xxx.txt" );
        System.out.println( "파일 연결" );
    }
}
