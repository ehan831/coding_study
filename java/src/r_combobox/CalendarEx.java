package r_combobox;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class CalendarEx {

    // 1. 멤버 변수 선언
    JFrame f;
    JComboBox cbY, cbM, cbD;
    JButton b;
    JLabel la;

    int[] lastDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    // 2. 멤버 변수 객체 생성
    CalendarEx() {
        Integer[] yse = new Integer[100];
        for (int i = 0, year = 2019; i < yse.length; i++) yse[i] = year - i;

        Integer[] msu = new Integer[12];
        for (int i = 0; i < msu.length; i++) msu[i] = i + 1;


        f = new JFrame( "날짜" );
        cbY = new JComboBox( yse );
        cbM = new JComboBox( msu );
        cbD = new JComboBox( );
        b = new JButton( "GO" );
        la = new JLabel( "요일" );
    }

    // 3. 화면 붙이기 및 화면 보이기
    void addLayout() {
        JPanel jp = new JPanel( );
        jp.setLayout( new FlowLayout( ) );
        jp.add( cbY );
        jp.add( new Label( "년" ) );
        jp.add( cbM );
        jp.add( new Label( "월" ) );
        jp.add( cbD );
        jp.add( new Label( "일" ) );
        jp.add( b );
        jp.add( la );

        f.add( jp );
        f.setSize( 700, 300 );
        f.setVisible( true );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    // 4. 이벤트 등록 및 처리
    void eventProc() {
        CbHdlr cb = new CbHdlr( );
        cbY.addActionListener( cb );
        cbM.addActionListener( cb );
        cbD.addActionListener( cb );
        b.addActionListener( cb );
    }

    class CbHdlr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource( );
            if (obj == cbY | obj == cbM) setDay( );
            else if (obj == b) setDate( );
        }
    }

    void setDay() {
//        System.out.println( "콤보박스 이벤트" );
        int year = (int) cbY.getSelectedItem( );


        // 윤년인 경우라면?! lastdays[1](2월)을 29로 바꿔야 함
        // 평년이라면 lastdays[1] = 28
        if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            System.out.println( "윤년" );
            lastDays[1] = 29;
        } else {
            System.out.println( "평년" );
            lastDays[1] = 28;
        }


        int month = cbM.getSelectedIndex( );
        cbD.removeAllItems( );
        for (int i = 1; i <= lastDays[month]; i++) {
            cbD.addItem( i );
        }
    }

    // 버튼을 누르면 해당 요일 출력
    // 처음 화면 뜰 때 오늘 날짜로 지정
    void setDate() {
        System.out.println( "버튼 이벤트" );
        Calendar c = Calendar.getInstance( );
        c.set( (int) cbY.getSelectedItem( ), (int) cbM.getSelectedItem( ) - 1, (int) cbD.getSelectedItem( ) );
        int date = c.get( Calendar.DAY_OF_WEEK );
        String[] strDate = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        la.setText( strDate[date - 1] ); // month 는 0부터 시작되어서...
    }

    void initDate() {
        Calendar c = Calendar.getInstance();
        int y = c.get( Calendar.YEAR );
        cbY.setSelectedItem( y );

        int m = c.get( Calendar.MONTH ) + 1;
        cbM.setSelectedItem( m );

        setDay( ); // 요일 계산


        int d = c.get( Calendar.DATE);
        cbD.setSelectedItem( d );

        setDate( ); // 일 계산

    }

    public static void main(String[] args) {
        CalendarEx c = new CalendarEx( );
        c.addLayout( );
        c.initDate( ); // 날짜 초기화
        c.eventProc( );
    }
}
