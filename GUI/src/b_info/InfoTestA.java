//package b_info;
//
//import jdk.nashorn.internal.scripts.JO;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//
////IS-A
//public class InfoTestA {
//    // 1. 멤버 변수 선언
//    private JFrame f;
//    private JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
//    private JTextArea ta;
//    private JTextField tfName, tfId, tfTel, tfSex, tfAge, tfHome;
//
//    private ArrayList<Person> list = new ArrayList<>( );
//
//    // 2. 멤버 객체 생성
//    private InfoTestA() {
//        f = new JFrame( );
//        bAdd = new JButton( "Add", new ImageIcon( "src/img/128x128 1.png" ) );
//        bAdd.setRolloverIcon( new ImageIcon( "src/img/64x64.png" ) );
//        bAdd.setPressedIcon( new ImageIcon( "src/img/128x128 6.png" ) );
//        bAdd.setToolTipText( "디비에 입력합니다." );
//        bAdd.setMnemonic( 'i' );
//        bAdd.setVerticalTextPosition( JButton.BOTTOM );
//        bAdd.setHorizontalTextPosition( JButton.CENTER );
//
//        bShow = new JButton( "Show", new ImageIcon( "src/img/128x128 2.png" ) );
//        bShow.setVerticalTextPosition( JButton.BOTTOM );
//        bShow.setHorizontalTextPosition( JButton.CENTER );
//
//        bSearch = new JButton( "Search", new ImageIcon( "src/img/128x128 3.png" ) );
//        bSearch.setVerticalTextPosition( JButton.BOTTOM );
//        bSearch.setHorizontalTextPosition( JButton.CENTER );
//
//        bDelete = new JButton( "Delete", new ImageIcon( "src/img/128x128 4.png" ) );
//        bDelete.setVerticalTextPosition( JButton.BOTTOM );
//        bDelete.setHorizontalTextPosition( JButton.CENTER );
//
//        bCancel = new JButton( "Cancel", new ImageIcon( "src/img/128x128 5.png" ) );
//        bCancel.setVerticalTextPosition( JButton.BOTTOM );
//        bCancel.setHorizontalTextPosition( JButton.CENTER );
//
//        bExit = new JButton( "Exit", new ImageIcon( "src/img/128x128 6.png" ) );
//        bExit.setVerticalTextPosition( JButton.BOTTOM );
//        bExit.setHorizontalTextPosition( JButton.CENTER );
//
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
//        f.setSize( 980, 750 );
//        f.setVisible( true );
//        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//    }
//
//    // 4. 이벤트 등록
//    private void eventProc() {
//        BtnHdlr bh = new BtnHdlr( );
//        // 버튼과 이벤트 핸들러 연결
//        bAdd.addActionListener( bh );
//        bShow.addActionListener( bh );
//        bSearch.addActionListener( bh );
//        bDelete.addActionListener( bh );
//        bCancel.addActionListener( bh );
//        bExit.addActionListener( bh );
//
//        // 전화번호 텍스트 필드의 엔터 이벤트
//        tfTel.addActionListener( new TfHdlr( ) );
//
//        // 주민번호 텍스트 필드의 포커스 로스트 이벤트
//        tfId.addFocusListener( new IdFocus( ) );
//    }
//
//    class TfHdlr implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            searchTel( );
//        }
//    }
//
//    // end of evenProc()
//    class IdFocus implements FocusListener {
//
//        @Override
//        public void focusGained(FocusEvent e) {
//
//        }
//
//        @Override
//        public void focusLost(FocusEvent e) {
//            System.out.println( "포커스 로스트" );
//
//            String id = tfId.getText();
//
//            // sex set
//            char sung = id.charAt( 7 );
//            if(sung == '1' || sung == '3') {
//                tfSex.setText( "남자" );
//            } else tfSex.setText( "여자" );
//
//
//            // age set
//            int age;
//            Calendar cal = Calendar.getInstance( );
//            int year = cal.get( Calendar.YEAR );
//            int nai = Integer.parseInt( id.substring( 0,2 ) );
//
//            // 주민번호 7번째가 1,2면 1900 | 3,4면 2000
//            if (sung == '1' | sung == '2') {
//                age = year - (1900 + nai) + 1;
//                tfAge.setText( String.valueOf(age) );
//            } else if (sung == '3' | sung == '4') {
//                age = year - (2000 + nai) + 1;
//                tfAge.setText( String.valueOf(age) );
//            } else {
//                tfAge.setText( "오류 발생" );
//            }
//
//            // home set
//            char state = id.charAt( 8 );
//            String home;
//
//            switch (state) {
//                case '0':
//                    home = "서울";
//                    break;
//                case '1':
//                    home = "인천/부산";
//                    break;
//                case '2':
//                    home = "경기";
//                    break;
//                case '9':
//                    home = "제주";
//                    break;
//                default:
//                    home = "해당 없음";
//            }
//            tfHome.setText( home );
//        }
//    }
//
//    private void searchTel() {
//        // (1) 사용자가 입력한 전화번호 얻어오기
//        String tel = tfTel.getText( );
//        // (2) ArrayList 의 각 Person 의 tel 과 비교해서 같은지
//        // (3) 해당 Person 의 멤버값들을 각각 텍스트 필드에 출력
//        for (Person p : list) {
//            if (p.getTel( ).equals( tel )) {
//                tfName.setText( p.getName( ) );
//                tfId.setText( p.getId( ) );
//                tfTel.setText( p.getTel( ) );
//                tfSex.setText( p.getSex( ) );
//                tfAge.setText( String.valueOf( p.getAge( ) ) );
//                tfHome.setText( p.getHome( ) );
//            }
//        }
//    }
//
//    private void delete() {
//        // (1) 사용자가 입력한 전화번호 얻어오기
//        String tel = tfTel.getText( );
//        // (2) ArrayList 의 각 Person 의 tel 과 비교해서 같은지
//        // (3) 해당 Person 의 멤버값들을 각각 텍스트 필드에 출력
//        for (Person p : list) {
//            if (p.getTel( ).equals( tel )) {
//                list.remove( p );
//                break;
//            }
//        }
//        clearTextField( );
//        showInfo( );
//    }
//
//    // 종료버튼이 눌러졌을 때 강제로 프로그램 종료  >> System.exit(0);
//    class BtnHdlr implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            Object evt = e.getSource( );
//            if (evt == bAdd) {
//                insert( );   // 입력 버튼이 눌렸을 때
//                clearTextField( );
//            } else if (evt == bShow) {
//                showInfo( );
//            } else if (evt == bSearch) {
//                searchTel( );
//            } else if (evt == bDelete) {
//                delete( );
//            } else if (evt == bCancel) {
//                clearTextField( );
//            } else if (evt == bExit) {
//                exit( );
//            }
//        }
//    }
//
//    private void insert() {
//        // (1) 각 텍스트 필드의 입력값을 얻어오기
//        // (2) 1번의 값들을 Person 의 멤버로 지정 - 방법1. 생성자 // 방법2. setter
//        // (3) ArrayList 에 2번 객체를 추가
////        String id = tfName.getText( );
////        String tel = tfName.getText( );
////        String sex = tfName.getText( );
////        String age = tfName.getText( );
////        String home = tfName.getText( );
//
//
//        Person p = new Person( );
//        p.setName( tfName.getText( ) );
//        p.setId( tfId.getText( ) );
//        p.setTel( tfTel.getText( ) );
//        p.setSex( tfSex.getText( ) );
//        p.setAge( Integer.parseInt( tfAge.getText( ) ) );
//        p.setHome( tfHome.getText( ) );
//        list.add( p );
//    }
//
//    private void clearTextField() {
//        tfName.setText( null );
//        tfId.setText( null );
//        tfTel.setText( null );
//        tfSex.setText( null );
//        tfAge.setText( null );
//        tfHome.setText( null );
//    }
//
//    void showInfo() {
//        ta.setText( "=================== 전체보기 ===================\n\n" );
//        for (Person p : list) {
//            ta.append( p.toString( ) );
//        }
//    }
//
//    void exit() {
//        int result = JOptionPane.showConfirmDialog( null, "정말로 나가시겠습니까?" );
//        if (result == JOptionPane.YES_OPTION) {
//            System.exit( 0 );
//        }
//    }
//
//    public static void main(String[] args) {
//        InfoTestA it = new InfoTestA( );
//        it.addLayout( );
//        it.eventProc( );
//    }
//}
