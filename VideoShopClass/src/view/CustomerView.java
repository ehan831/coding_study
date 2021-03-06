package view;

import model.CustomerDao;
import model.dao.CustomerModel;
import model.vo.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerView extends JPanel {
    JTextField tfCustName, tfCustTel, tfCustTelAid, tfCustAddr, tfCustEmail;
    JButton bCustRegist, bCustModify;

    JTextField tfCustNameSearch, tfCustTelSearch;
    JButton bCustNameSearch, bCustTelSearch;

    CustomerDao dao;

    public CustomerView() {
        addLayout( );
        connectDB( );
        eventProc( );
    }

    public void eventProc() {
        ButtonEventHandler btnHandler = new ButtonEventHandler( );

        // 이벤트 등록
        bCustRegist.addActionListener( btnHandler );
        bCustModify.addActionListener( btnHandler );
        bCustNameSearch.addActionListener( btnHandler );
        bCustTelSearch.addActionListener( btnHandler );
    }

    // 버튼 이벤트 핸들러 만들기
    class ButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object o = ev.getSource( );

            if (o == bCustRegist) {
                registCustomer( );  // 회원등록
            } else if (o == bCustModify) {
                updateCustomer( );  // 회원정보수정
            } else if (o == bCustTelSearch) {  // 이름검색
                searchByTel( );      // 전화번호 검색
            } else if (o == bCustNameSearch) {  // 이름검색
                System.out.println( "이름 검색" );
            }
        }
    }

    // 회원가입하는 메소드
    public void registCustomer() {

        // 1. 화면 텍스트필드의 입력값 얻어오기
        // 2. 1값들을 Customer 클래스의 멤버로지정
        // 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
        // 4. 화면 초기화
        //JOptionPane.showMessageDialog(null, "입력");
        Customer vo = new Customer( );
        System.out.println( "회원가입 호출 성공" );

        vo.setCustName( tfCustName.getText( ) );
        vo.setCustTel1( tfCustTel.getText( ) );
        vo.setCustTel2( tfCustTelAid.getText( ) );
        vo.setCustAddr( tfCustAddr.getText( ) );
        vo.setCustEmail( tfCustEmail.getText( ) );
        try {
            dao.insertCustomer( vo );
        } catch (Exception ex) {
            System.out.println( "회원 가입 실패" + ex.getMessage( ) );
        }
        clearTextField( );
    }


    // 전화번호에 의한 검색
    public void searchByTel() {
        // 1. 입력한 전화번호 얻어오기
        // 2. Model의 전화번호 검색메소드 selectByTel()  호출
        // 3. 2번의 넘겨받은 Customer의 각각의 값을 화면 텍스트 필드 지정

        //JOptionPane.showMessageDialog(null, "검색");
        String tel = tfCustTelSearch.getText( );

        try {
            Customer vo = dao.selectByTel( tel );
            System.out.println( "검색 호출 성공" );

            tfCustName.setText( vo.getCustName( ) );
            tfCustTel.setText( vo.getCustTel1( ) );
            tfCustTelAid.setText( vo.getCustTel2( ) );
            tfCustAddr.setText( vo.getCustAddr( ) );
            tfCustEmail.setText( vo.getCustEmail( ) );

        } catch (Exception ex) {
            System.out.println( "번호 검색 실패" + ex.getMessage() );
        }
    }

    // 회원정보수정
    public void updateCustomer() {

        Customer vo = new Customer( );
        vo.setCustName( tfCustName.getText( ) );
        vo.setCustTel1( tfCustTel.getText( ) );
        vo.setCustTel2( tfCustTelAid.getText( ) );
        vo.setCustAddr( tfCustAddr.getText( ) );
        vo.setCustEmail( tfCustEmail.getText( ) );

        try {
            int result = dao.updateCustomer( vo );
//         JOptionPane.showMessageDialog(null, result + "개 수정");
            System.out.println( result );
            if (result != 0) {
                JOptionPane.showMessageDialog( null, result + "개 수정" );
                clearTextField( );
            } else {
                JOptionPane.showMessageDialog( null, "존재하지 않는 데이터" );
            }
        } catch (Exception ex) {
            System.out.println( "수정 불가" + ex.getMessage() );
        }
        //
    }

    void clearTextField() {
        tfCustName.setText( null );
        tfCustTel.setText( null );
        tfCustTelAid.setText( null );
        tfCustAddr.setText( null );
        tfCustEmail.setText( null );
    }


    public void connectDB() {
        try {
            dao = new CustomerModel( );
        } catch (Exception e) {
            System.out.println( "customerModel fail" + e.getMessage( ) );
            JOptionPane.showMessageDialog( null, "오류 : 드라이버 오류" );
        }

    }

    public void addLayout() {

        tfCustName = new JTextField( 20 );
        tfCustTel = new JTextField( 20 );
        tfCustTelAid = new JTextField( 20 );
        tfCustAddr = new JTextField( 20 );
        tfCustEmail = new JTextField( 20 );


        tfCustNameSearch = new JTextField( 20 );
        tfCustTelSearch = new JTextField( 20 );

        bCustRegist = new JButton( "회원가입" );
        bCustModify = new JButton( "회원수정" );
        bCustNameSearch = new JButton( "이름검색" );
        bCustTelSearch = new JButton( "번호검색" );

        // 회원가입 부분 붙이기
        //		( 그 복잡하다던 GridBagLayout을 사용해서 복잡해 보임..다른 쉬운것으로...대치 가능 )
        JPanel pRegist = new JPanel( );
        pRegist.setLayout( new GridBagLayout( ) );
        GridBagConstraints cbc = new GridBagConstraints( );
        cbc.weightx = 1.0;
        cbc.weighty = 1.0;
        cbc.fill = GridBagConstraints.BOTH;
        cbc.gridx = 0;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( new JLabel( "	이	름	" ), cbc );
        cbc.gridx = 1;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( tfCustName, cbc );
        cbc.gridx = 2;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( bCustModify, cbc );
        cbc.gridx = 3;
        cbc.gridy = 0;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( bCustRegist, cbc );

        cbc.gridx = 0;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( new JLabel( "	전	화	" ), cbc );
        cbc.gridx = 1;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( tfCustTel, cbc );
        cbc.gridx = 2;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( new JLabel( " 추가전화  " ), cbc );
        cbc.gridx = 3;
        cbc.gridy = 1;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( tfCustTelAid, cbc );

        cbc.gridx = 0;
        cbc.gridy = 2;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( new JLabel( "	주	소	" ), cbc );
        cbc.gridx = 1;
        cbc.gridy = 2;
        cbc.gridwidth = 3;
        cbc.gridheight = 1;
        pRegist.add( tfCustAddr, cbc );

        cbc.gridx = 0;
        cbc.gridy = 3;
        cbc.gridwidth = 1;
        cbc.gridheight = 1;
        pRegist.add( new JLabel( "	이메일	" ), cbc );
        cbc.gridx = 1;
        cbc.gridy = 3;
        cbc.gridwidth = 3;
        cbc.gridheight = 1;
        pRegist.add( tfCustEmail, cbc );


        // 회원검색 부분 붙이기
        JPanel pSearch = new JPanel( );
        pSearch.setLayout( new GridLayout( 2, 1 ) );
        JPanel pSearchName = new JPanel( );
        pSearchName.add( new JLabel( "		이 	름	" ) );
        pSearchName.add( tfCustNameSearch );
        pSearchName.add( bCustNameSearch );
        JPanel pSearchTel = new JPanel( );
        pSearchTel.add( new JLabel( "	전화번호	" ) );
        pSearchTel.add( tfCustTelSearch );
        pSearchTel.add( bCustTelSearch );
        pSearch.add( pSearchName );
        pSearch.add( pSearchTel );

        // 전체 패널에 붙이기
        setLayout( new BorderLayout( ) );
        add( "Center", pRegist );
        add( "South", pSearch );

    }


}			 	
				 	
