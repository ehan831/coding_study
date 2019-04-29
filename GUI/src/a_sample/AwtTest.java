package a_sample;

import java.awt.*;
import javax.swing.*;

/**
 * JAVA GUI
 * AWT - 1.2 ver 이전
 * Swing - 1.2 ver 이후
 */

// AWT >> Swing 앞에 J를 붙이면 됨

public class AwtTest extends JFrame {
    // 1. 멤버 변수를 선언하는 위치
    JButton b1, b2;
    JTextField tf;
    JTextArea ta;
    JRadioButton cb1, cb2;

    AwtTest() {
        super( "나의 두번째 창" );
        // 2. 객체 생성
        b1 = new JButton( "확인" );
        b2 = new JButton( "취소" );
        tf = new JTextField( 30 );
        ta = new JTextArea( 10, 50 );
        cb1 = new JRadioButton( "남자" );
        cb2 = new JRadioButton( "여자" );

        ButtonGroup bg = new ButtonGroup();
        bg.add(cb1);
        bg.add(cb2);
    }

    void addLayout() {
        // 3. 화면에 붙이기
//        FlowLayout f1 = new FlowLayout( );    // 윗줄 상단 중앙에 배치 - 컨포넌트의 크기가 고정
//        setLayout( f1 );  //         setLayout( new FlowLayout( ) ); 줄여쓰기 가능
//        setLayout( new GridLayout( 3,2 ) ); // 설정한 rows, cols 에 따라 - 크기가 가변적
//        add( b1 );
//        add( b2 );
//        add( tf );
//        add( ta );
//        add( cb1 );
//        add( cb2 );

        setLayout( new BorderLayout( ) );  // 5가지의 영역으로 분리되어 있음. NORTH, SOUTH, EASE, WEST, CENTER
        add( b1, BorderLayout.NORTH );
        add( b2, BorderLayout.SOUTH );
        add( tf, BorderLayout.WEST );
        add( ta, BorderLayout.CENTER );

//        add( cb1, BorderLayout.EAST );
//        add( cb2, BorderLayout.EAST );  // 중복되게 위치 설정하면, 안나오네
        JPanel p = new JPanel(  );
        p.add(cb1);
        p.add(cb2);
        add( p, BorderLayout.EAST);


        // 4. 화면에 출력
        setSize( 600, 480 );
        setVisible( true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        AwtTest at = new AwtTest( );
        at.addLayout( );
    }
}
