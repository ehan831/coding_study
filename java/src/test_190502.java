import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test_190502 {
    JFrame f = new JFrame( );
    JPanel parent_panel, first_panel, second_panel, third_panel;
    JButton b1, b2, b3, b4, b5, b6;
    CardLayout card;
    public test_190502() {

        card = new CardLayout( );
        parent_panel = new JPanel( );

        parent_panel.setLayout( card );


        first_panel = new JPanel( );
        b1 = new JButton( "주문 전체 취소" );
        b2 = new JButton( "NEXT >  샷 및 시럽 추가" );
        first_panel.add( b1 );
        first_panel.add( b2 );


        second_panel = new JPanel( );
        second_panel.setBackground( new Color( 233, 164, 22 ) );
        b3 = new JButton( "1. 이전으로" );
        b4 = new JButton( "NEXT > 할인 및 완료" );
        second_panel.add( b3 );
        second_panel.add( b4 );

        third_panel = new JPanel( );
        third_panel.setBackground( new Color( 233, 206, 215 ) );
        b5 = new JButton( "2. 이전으로" );
        b6 = new JButton( "주문 완료" );
        third_panel.add( b5 );
        third_panel.add( b6 );

        parent_panel.add("1", first_panel);
        parent_panel.add("2", second_panel);
        parent_panel.add("3", third_panel);


        f.add(parent_panel);
    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource( );
            if (obj == b2 | obj == b4) {
//                card.next(f);
                card.next( parent_panel );
            } else if (obj == b3 | obj == b5) {
                card.previous( parent_panel );
            } else if (obj == b1 | obj == b6) System.exit( 0 );
        }
    }

    void eventProc() {
        Handler hd = new Handler( );
        b1.addActionListener( hd );
        b2.addActionListener( hd );
        b3.addActionListener( hd );
        b4.addActionListener( hd );
        b5.addActionListener( hd );
        b6.addActionListener( hd );
    }

    void addLayout() {
        f.setSize( 500, 500 );
        f.setVisible( true );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public static void main(String[] args) {
        test_190502 tt = new test_190502( );
        tt.addLayout( );
        tt.eventProc( );
    }
}