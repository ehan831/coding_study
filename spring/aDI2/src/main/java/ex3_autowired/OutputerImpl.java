package ex3_autowired;

import java.io.FileWriter;
import java.io.IOException;

public class OutputerImpl implements Outputer {

    private String path;

    // 값 지정하려면 // 1. 생성자 // 2. setter
    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public void writeMessage(String msg) throws IOException {
        FileWriter f = new FileWriter( path );
        f.write( msg );
        f.close();
    }
}
