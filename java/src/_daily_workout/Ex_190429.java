package _daily_workout;

import javax.swing.*;
import java.awt.*;

public class Ex_190429 extends JFrame {

    // 1. 멤버변수
    private JTextField tf;
    private JButton b10_Plus, b0, b11_Equals, b12_Minus, b13_Multiply, b14_Divide;
    JButton[] buttons = new JButton[10];

    // 2. 객체 생성
    private Ex_190429() {
        super("유치원 계산기");

        for(int i=1; i<buttons.length; i++) {
            buttons[i] = new JButton ( i+"" );
        }
        b10_Plus = new JButton( "+" );
        b0 = new JButton( "0" );
        b11_Equals = new JButton( "=" );
        b12_Minus = new JButton( "-" );
        b13_Multiply = new JButton( "*" );
        b14_Divide = new JButton( "/" );

        tf = new JTextField( );
    }


    private void addLayout() {
        //South
        JPanel c_south = new JPanel( );
        c_south.setLayout( new GridLayout( 5, 3 ) );
        for (int i = 1; i < buttons.length; i++) {
            c_south.add( buttons[i] );
        }
        c_south.add( b10_Plus );
        c_south.add( b0 );
        c_south.add( b11_Equals );
        c_south.add( b12_Minus );
        c_south.add( b13_Multiply );
        c_south.add( b14_Divide );

        // 붙이기

        setLayout( new BorderLayout(  ) );
        add( c_south, BorderLayout.CENTER );
        add( tf, BorderLayout.NORTH);


        setSize( 300, 350 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


    public static void main(String[] args) {
        Ex_190429 ce = new Ex_190429( );
        ce.addLayout( );
    }
}
