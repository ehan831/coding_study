package c_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestC extends JFrame {

    JButton b;
    JTextField tf;

    TestC() {
        b = new JButton( "눌러봐버튼" );
        tf = new JTextField( "입력해봐", 20 );
    }

    void addLayout() {
        setLayout( new FlowLayout( ) );
        add( b );
        add( tf );
        setSize( 400, 300 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    void eventProc() {
        b.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, "이벤트 발생1" );
            }
        } );
        tf.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, "이벤트 발생2" );
            }
        } );
    }

    public static void main(String[] args) {
        TestC t = new TestC( );
        t.addLayout( );
        t.eventProc( );
    }
}


