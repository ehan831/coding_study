package c_event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestA extends JFrame {

    JButton b;
    JTextField tf;

    TestA() {
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
        // 2. 핸들러 객체 생성
        MyEvent me = new MyEvent( );

        // 3. 이벤트 발생을 원하는 컨포넌트와 연결
        b.addActionListener( me );
        tf.addActionListener( me );
    }

    // 1. 이벤트 핸들러
    class MyEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource( );
            if (obj == b) {
                String msg = b.getText();
                JOptionPane.showMessageDialog( null, msg + "이벤트 발생" );
            } else {
                String msg = tf.getToolTipText();
                JOptionPane.showMessageDialog( null, msg + "를 입력했습니다." );
            }
        }
    }


    public static void main(String[] args) {
        TestA t = new TestA( );
        t.addLayout( );
        t.eventProc( );
    }
}
