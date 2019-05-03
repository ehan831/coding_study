//package b_info;
//
//import javax.swing.*;
//import java.awt.*;
//
//
////IS-A
//public class InfoTest {
//    // 1. 멤버 변수 선언
//    private JFrame f;
//    private JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
//    private JTextArea ta;
//    private JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
//
//    // 2. 멤버 객체 생성
//    private InfoTest() {
//        f = new JFrame( );
//        bAdd = new JButton( "Add" );
//        bShow = new JButton( "Show" );
//        bSearch = new JButton( "Search" );
//        bDelete = new JButton( "Delete" );
//        bCancel = new JButton( "Cancel" );
//        bExit = new JButton( "Exit" );
//        ta = new JTextArea( );
//        tfName = new JTextField( 15 );
//        tfId = new JTextField( );
//        tfTel = new JTextField( );
//        tfSex = new JTextField( );
//        tfAge = new JTextField( );
//        tfHome = new JTextField( );
//    }
//
//    // 3. 화면 붙이기 및 화면 출력
//    private void addLayout() {
//        //South
//        JPanel p_south = new JPanel( );
//        p_south.setLayout( new GridLayout( 1, 6 ) );
//        p_south.add( bAdd );
//        p_south.add( bShow );
//        p_south.add( bSearch );
//        p_south.add( bDelete );
//        p_south.add( bCancel );
//        p_south.add( bExit );
//
//        //West
//        JPanel p_west = new JPanel( );
//        p_west.setLayout( new GridLayout( 6, 2 ) );
//        p_west.add( new JLabel( "Name" ) );
//        p_west.add( tfName );
//        p_west.add( new JLabel( "ID" ) );
//        p_west.add( tfId );
//        p_west.add( new JLabel( "Tel" ) );
//        p_west.add( tfTel );
//        p_west.add( new JLabel( "Sex" ) );
//        p_west.add( tfSex );
//        p_west.add( new JLabel( "Age" ) );
//        p_west.add( tfAge );
//        p_west.add( new JLabel( "Home" ) );
//        p_west.add( tfHome );
//
//        // 프레임 영역에 붙이기
//        f.setLayout( new BorderLayout( ) );
//        f.add( p_south, BorderLayout.SOUTH );
//        f.add( p_west, BorderLayout.WEST );
//        f.add( ta, BorderLayout.CENTER );
//
//        f.setSize( 780, 580 );
//        f.setVisible( true );
//        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//    }
//
//    public static void main(String[] args) {
//        InfoTest it = new InfoTest( );
//        it.addLayout( );
//    }
//}
