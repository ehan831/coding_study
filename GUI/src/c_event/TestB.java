package c_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestB extends JFrame implements ActionListener {

    JButton b;
    JTextField tf;

    TestB() {
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

    // 이벤트 처리
    void eventProc() {
        b.addActionListener( this );
        tf.addActionListener( this );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog( null, "이벤트 발생" );
    }


    public static void main(String[] args) {
        TestB t = new TestB();
        t.addLayout();
        t.eventProc();
    }

}
