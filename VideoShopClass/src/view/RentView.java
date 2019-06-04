package view;

import model.dao.RentModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RentView extends JPanel {
    JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
    JButton bRent;

    JTextField tfReturnVideoNum;
    JButton bReturn;

    JTable tableRecentList;

    RentTableModel rentTM;

    // 비지니스 로직 = 모델 클래스 변수 선언
    RentModel db;

    //==============================================
    //	 생성자 함수
    public RentView() {
        addLayout( );    //화면구성
        eventProc( );    //DB연결
        connectDB( );
    }

    // DB 연결
    void connectDB() {
        try {
            db = new RentModel( );
        } catch (Exception e) {
            System.out.println( "드라이버 로딩 실패" + e.getMessage( ) );
        }
    }


    // 이벤트 등록
    public void eventProc() {
        ActionHandler ah =  new ActionHandler();
        //이벤트가 발생할 객체를 핸들러로 연결
        bRent.addActionListener( ah );
        bReturn.addActionListener( ah );
        tfRentTel.addActionListener( ah );  // 전화번호 필드 - 엔터치면 검색
    }

    //
    class ActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println( "이벤트" );    // 이벤트 발생하는지 알아보려고 최초에 활용
            Object o = e.getSource();

            if( o == bRent) {
                rentVideo();
            }else if ( o == bReturn) {
                returnVideo();
                selectNonReturn();
            }else if ( o == tfRentTel) {
                selectCTel();
                selectNonReturn();
            }
        }
    }

    // 비디오 대여하는 메소드
    private void rentVideo() {
        // 1. 화면에서 필요한 정보를 얻어오기
        // 2. 모델 쪽 메소드 호출
        // 3. 대여 후 결과처리
        String tel = tfRentTel.getText();
        String vnum = tfRentVideoNum.getText();
        try {
            db.rentVideo( tel, vnum );
        } catch (Exception e) {
            e.printStackTrace( );
        }
    }

    // 비디오 반납하는 메소드
    private void returnVideo() {
        String vnum = tfReturnVideoNum.getText();
        try {
            String vnum_result = db.returnVideo( vnum );
            JOptionPane.showMessageDialog( null, vnum_result + " 반납완료" );
        } catch (Exception e) {
            e.printStackTrace( );
        }

    }

    // 전화번호 입력하고 엔터쳤을 때, 검색하는 메소드
    private void selectCTel() {
        String tel = tfRentTel.getText();
    }

    // 미납 목록 보여주는 메소ㅓ드
    private void selectNonReturn() {
        try {
            rentTM.data = db.selectList( );
            rentTM.fireTableDataChanged( );
        } catch (Exception e) {
            e.printStackTrace( );
        }
    }


    /*	객체 생성 및 화면 구성   */
    void addLayout() {
        tfRentTel = new JTextField( );
        tfRentCustName = new JTextField( );
        tfRentVideoNum = new JTextField( );
        tfReturnVideoNum = new JTextField( 15 );
        bRent = new JButton( "대 여" );
        bReturn = new JButton( "반 납" );
        rentTM = new RentTableModel( );
        tableRecentList = new JTable( rentTM );

        /** 1. 구조 생성 */
        // 상단
        JPanel n_panel = new JPanel( );
        // 상단 - 좌측
        JPanel n_panel_left = new JPanel( );
        n_panel_left.setBorder( new TitledBorder( "대여" ) );
        n_panel_left.setLayout( new GridLayout( 4, 2 ) );

        // 상단 - 우측
        JPanel n_panel_right = new JPanel( );
        n_panel_right.setBorder( new TitledBorder( "반납" ) );
//        n_panel_right.setLayout( new GridLayout( 1, 3 ) );


        /** 2. 화면 구성 */

        // 전체에 붙이기
        setLayout( new BorderLayout( ) );
        add( n_panel, BorderLayout.NORTH );
        add( new JScrollPane( tableRecentList ), BorderLayout.CENTER );

        // 상단 좌,우 붙이기
        n_panel.setLayout( new GridLayout( 1, 2 ) );
        n_panel.add( n_panel_left );
        n_panel.add( n_panel_right );

        // 상단 좌 - 디테일
        n_panel_left.add( new JLabel( " 전화번호   :" ) );
        n_panel_left.add( tfRentTel );
        n_panel_left.add( new JLabel( " 고객명   :" ) );
        n_panel_left.add( tfRentCustName );
        n_panel_left.add( new JLabel( " 비디오번호   :" ) );
        n_panel_left.add( tfRentVideoNum );
        n_panel_left.add( bRent );

        // 상단 우 - 디테일
        n_panel_right.add( new JLabel( "비디오 번호 : " ));
        n_panel_right.add( tfReturnVideoNum );
        n_panel_right.add( bReturn );

    }

    class RentTableModel extends AbstractTableModel {

        ArrayList data = new ArrayList( );
        String[] columnNames = {"비디오번호", "제목", "고객명", "전화번호", "반납예정일", "반납여부"};

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size( );
        }

        public Object getValueAt(int row, int col) {
            ArrayList temp = (ArrayList) data.get( row );
            return temp.get( col );
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }
    }


}
