package b_info;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.plaf.basic.BasicTreeUI.MouseHandler;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//IS-A
public class InfoTestC {
    // 1. 멤버 변수 선언
    private JFrame f;
    private JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
    private JTextArea ta;
    private JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;

    // 2. 멤버 객체 생성
    private InfoTestC() {
        f = new JFrame( );
        bAdd = new JButton( "Add" );
        bShow = new JButton( "Show" );
        bSearch = new JButton( "Search" );
        bDelete = new JButton( "Delete" );
        bCancel = new JButton( "Cancel" );
        bExit = new JButton( "Exit" );
        ta = new JTextArea( );
        tfName = new JTextField( 15 );
        tfId = new JTextField( );
        tfTel = new JTextField( );
        tfSex = new JTextField( );
        tfAge = new JTextField( );
        tfHome = new JTextField( );
    }

    // 3. 화면 붙이기 및 화면 출력
    private void addLayout() {
        //South
        JPanel p_south = new JPanel( );
        p_south.setLayout( new GridLayout( 1, 6 ) );
        p_south.add( bAdd );
        p_south.add( bShow );
        p_south.add( bSearch );
        p_south.add( bDelete );
        p_south.add( bCancel );
        p_south.add( bExit );

        //West
        JPanel p_west = new JPanel( );
        p_west.setLayout( new GridLayout( 6, 2 ) );
        p_west.add( new JLabel( "Name" ) );
        p_west.add( tfName );
        p_west.add( new JLabel( "ID" ) );
        p_west.add( tfId );
        p_west.add( new JLabel( "Tel" ) );
        p_west.add( tfTel );
        p_west.add( new JLabel( "Sex" ) );
        p_west.add( tfSex );
        p_west.add( new JLabel( "Age" ) );
        p_west.add( tfAge );
        p_west.add( new JLabel( "Home" ) );
        p_west.add( tfHome );

        // 프레임 영역에 붙이기
        f.setLayout( new BorderLayout( ) );
        f.add( p_south, BorderLayout.SOUTH );
        f.add( p_west, BorderLayout.WEST );
        f.add( ta, BorderLayout.CENTER );

        f.setSize( 780, 580 );
        f.setVisible( true );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }


//    class MyHdlr extends MouseAdapter { } // MouseListener 하면 죄다 오버라이드 해야되니까, 간단하게는 MouseAdapter 로 구현 가능하다.
    class MyHdlr implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Object obj = e.getSource();
            if(obj == bExit) {
                System.exit( 0 );
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    void eventProc() {
        MyHdlr mh = new MyHdlr();
        bExit.addMouseListener( mh );
    }

    public static void main(String[] args) {
        InfoTestC it = new InfoTestC( );
        it.addLayout( );
        it.eventProc();
    }
}
