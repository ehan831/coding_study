package c_event;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    JButton b;
    JTextField tf;

    Test() {
        b = new JButton( "눌러봐버튼" );
        tf = new JTextField( "입력해봐", 20 );

    }

    void addLayout() {
        setLayout( new FlowLayout(  ) );
        add( b );
        add( tf );
        setSize( 400,300 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }

    public static void main(String[] args) {
        Test t = new Test();
        t.addLayout();
    }
}
