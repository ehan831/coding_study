package io.others;

import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File f = new File( "relative path..." );
        System.out.println( f.getPath( ) );
        System.out.println( f.getAbsolutePath( ) );

        if (f.isFile( )) {
            System.out.println( "파일 입니다" );
        } else {
            System.out.println( "디렉토리 입니다." );
            String[] sub = f.list( );
            for (String m : sub) {
                System.out.println( m );
            }
        }
        File f2 = new File( " " );
        f2.delete();
    }
}
