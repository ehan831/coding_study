package view;

import model.dao.VideoModel;
import model.vo.Video;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class VideoView extends JPanel {
    //	member field
    JTextField tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
    JComboBox comVideoJanre;
    JTextArea taVideoContent;

    JCheckBox cbMultiInsert;
    JTextField tfInsertCount;

    JButton bVideoInsert, bVideoModify, bVideoDelete;

    JComboBox comVideoSearch;
    JTextField tfVideoSearch;
    JTable tableVideo;

    VideoTableModel tbModelVideo;

    // 비지니스 로직 = 모델 클래스 변수 선언
    VideoModel db;

    //##############################################
    //	constructor method
    public VideoView() {
        addLayout( );    // 화면설계
        initStyle( );
        eventProc( );
        connectDB( );    // DB연결
    }

    public void connectDB() {    // DB연결
        try {
            db = new VideoModel( );
        } catch (Exception ex) {
            System.out.println( "드라이버 로딩 실패" + ex.getMessage() );
        }

    }

    public void eventProc() {
        ButtonEventHandler hdlr = new ButtonEventHandler( );
        bVideoInsert.addActionListener( hdlr );
        bVideoModify.addActionListener( hdlr );
        bVideoDelete.addActionListener( hdlr );
        tfVideoSearch.addActionListener( hdlr );

        cbMultiInsert.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfInsertCount.setEditable( cbMultiInsert.isSelected( ) );    // 체크박스가 true(선택되었음)면 수량을 편집 가능하도록 하기
            }
        } );
        // JTable 비디오 검색에서 클릭했을 때
        tableVideo.addMouseListener( new MouseAdapter( ) {
            public void mouseClicked(MouseEvent e) {
                int col = 0;
                int row = tableVideo.getSelectedRow( );
                int vNum = (Integer) tableVideo.getValueAt( row, col );
//                JOptionPane.showMessageDialog( null, vNum );
                // 1. 선택한 비디오 번호를 모델단의 selectByPk() 호출 시 인자로 보내기
                // 2. 넘겨 받은 video 에서 해당 값들 화면 출력하기
                Video vo = null;
                try {
                    vo = db.selectByPk(vNum);

                    tfVideoNum.setText( String.valueOf( vo.getVideoNo() ) );
                    comVideoJanre.setSelectedItem( vo.getGenre() );
                    tfVideoTitle.setText( vo.getVideoName() );
                    tfVideoDirector.setText( vo.getDirector() );
                    tfVideoActor.setText( vo.getActor() );
                    taVideoContent.setText( vo.getExp() );

                } catch (Exception e1) {
                    System.out.println( "실패" + e1.getMessage() );
                }
            }
        } );
    }

    // 버튼 이벤트 핸들러 만들기
    class ButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object o = ev.getSource( );

            if (o == bVideoInsert) {
                registVideo( );                    // 비디오 등록
            } else if (o == bVideoModify) {
                modifyVideo( );                    // 비디오 정보 수정
            } else if (o == bVideoDelete) {
                deleteVideo( );                    // 비디오 정보 삭제
            } else if (o == tfVideoSearch) {
                searchVideo( );                    // 비디오 검색
            }
        }
    }

//    int videoNo;                    // 비디오번호
//    String genre;                // 장르
//    String videoName;            // 비디오명
//    String director;                // 감독
//    String actor;                    // 배우
//    String exp;                    // 설명

    // 입고 클릭시  - 비디오 정보 등록
    public void registVideo() {
//        JOptionPane.showMessageDialog( null, "입고" );

        // 1. 화면의 입력 및 선택 값들 얻어오기  -> VO 객체로 생성
        Video vo = new Video( );
        vo.setGenre( String.valueOf( comVideoJanre.getSelectedItem( ) ) );
        vo.setVideoName( tfVideoTitle.getText( ) );
        vo.setDirector( tfVideoDirector.getText( ) );
        vo.setActor( tfVideoActor.getText( ) );
        vo.setExp( taVideoContent.getText( ) );

        int count = Integer.parseInt( tfInsertCount.getText( ) );
        System.out.println( count );
        // 2. 모델 단의 메소드 1번 값들을 전송
        try {
            db.insertVideo( vo, count );
        } catch (Exception e) {
            System.out.println( "실패" + e.getMessage( ) );
        }


    }

    public void initStyle() {   // 입력하지 못하게 만듬.
        tfVideoNum.setEditable( false ); // 편집만 못하게? // seEnabled 는 아예 값 자체를 못 받아옴?
        tfInsertCount.setEditable( false );
        tfInsertCount.setHorizontalAlignment( JTextField.RIGHT );
    }

    // 수정 클릭시 - 비디오 정보 수정
    public void modifyVideo() {
        JOptionPane.showMessageDialog( null, "수정" );
    }

    // 삭제 클릭시 - 비디오 정보 삭제
    public void deleteVideo() {

        JOptionPane.showMessageDialog( null, "삭제" );
    }

    // 비디오현황검색
    public void searchVideo() {
//        JOptionPane.showMessageDialog( null, "검색" );
        int sel = comVideoSearch.getSelectedIndex( );
        String word = tfVideoSearch.getText( );
        try {

            // 검색결과를 JTable의 내용을 담당하는 TableModel 안에 data에 지정
            tbModelVideo.data = db.searchVideo( sel, word );
            // 데이터가 들어오면 새로 고침!?
            tbModelVideo.fireTableDataChanged( );

        } catch (Exception e) {
            System.out.println( "검색 실패" + e.getMessage( ) );
        }
    }


    //  화면설계 메소드
    public void addLayout() {
        //멤버변수의 객체 생성
        tfVideoNum = new JTextField( );
        tfVideoTitle = new JTextField( );
        tfVideoDirector = new JTextField( );
        tfVideoActor = new JTextField( );

        String[] cbJanreStr = {"멜로", "엑션", "스릴", "코미디"};
        comVideoJanre = new JComboBox( cbJanreStr );
        taVideoContent = new JTextArea( );

        cbMultiInsert = new JCheckBox( "다중입고" );
        tfInsertCount = new JTextField( "1", 5 );

        bVideoInsert = new JButton( "입고" );
        bVideoModify = new JButton( "수정" );
        bVideoDelete = new JButton( "삭제" );

        String[] cbVideoSearch = {"제목", "감독"};
        comVideoSearch = new JComboBox( cbVideoSearch );
        tfVideoSearch = new JTextField( 15 );

        tbModelVideo = new VideoTableModel( );
        tableVideo = new JTable( tbModelVideo );    // 모델하고 화면하고 연결했

        //*********************************************************************
        // 화면 구성
        // 왼쪽 영역 패널
        JPanel p_west = new JPanel( );
//        p_west.setBorder( new TitledBorder( "west" ) );   // 보드 만들고 확인해보는 용도
        p_west.setLayout( new BorderLayout( ) );

        // 왼쪽 - 메인 영역
        JPanel p_west_main = new JPanel( );
        p_west_main.setLayout( new BorderLayout( ) );
        // 왼쪽 - 메인 - 센터
        JPanel p_west_main_center = new JPanel( );
        p_west_main_center.setBorder( new TitledBorder( "비디오 정보 입력" ) );
        // 왼쪽 - 메인 - 센터 - 1(비디오 정보)
        JPanel p_west_main_center_1 = new JPanel( );
        p_west_main_center_1.setLayout( new GridLayout( 5, 2 ) );
        p_west_main_center_1.add( new JLabel( "  비디오 번호   :" ) );
        p_west_main_center_1.add( tfVideoNum );
        p_west_main_center_1.add( new JLabel( "  장르   :" ) );
        p_west_main_center_1.add( comVideoJanre );
        p_west_main_center_1.add( new JLabel( "  제목   :" ) );
        p_west_main_center_1.add( tfVideoTitle );
        p_west_main_center_1.add( new JLabel( "  감독   :" ) );
        p_west_main_center_1.add( tfVideoDirector );
        p_west_main_center_1.add( new JLabel( "  배우   :" ) );
        p_west_main_center_1.add( tfVideoActor );

        // 왼쪽 - 메인 - 센터 - 2(비디오 설명)
        JPanel p_west_main_center_2 = new JPanel( );
        p_west_main_center_2.setLayout( new BorderLayout( ) );
        p_west_main_center_2.add( new JLabel( "  설명   :" ), BorderLayout.WEST );
        p_west_main_center_2.add( taVideoContent, BorderLayout.CENTER );

        // 왼쪽 - 메인 - 센터에 1,2 붙이기
        p_west_main_center.setLayout( new GridLayout( 2, 1 ) );
        p_west_main_center.add( p_west_main_center_1 );
        p_west_main_center.add( p_west_main_center_2 );

        // 왼쪽 - 메인 - 사우스
        JPanel p_west_main_south = new JPanel( );
        p_west_main_south.setBorder( new TitledBorder( "다중 입고 시 선택하시오" ) );
        p_west_main_south.add( cbMultiInsert );
        p_west_main_south.add( tfInsertCount );
        p_west_main_south.add( new JLabel( "개" ) );

        // 왼쪽에 메인 붙이기
        p_west.add( p_west_main, BorderLayout.CENTER );

        // 왼쪽 - 메인에 센터 사우스 붙이기
        p_west_main.add( p_west_main_center, BorderLayout.CENTER );
        p_west_main.add( p_west_main_south, BorderLayout.SOUTH );


        // 왼쪽 - 버튼 영역
        JPanel p_west_button = new JPanel( );
        p_west_button.setLayout( new GridLayout( 1, 3 ) );
        p_west_button.add( bVideoInsert );
        p_west_button.add( bVideoModify );
        p_west_button.add( bVideoDelete );
        p_west.add( p_west_button, BorderLayout.SOUTH );


        // 오른쪽 영역 패널
        JPanel p_east = new JPanel( );
//        p_east.setBorder( new TitledBorder( "east" ) );   // 보드 만들고 확인해보는 용도
        p_east.setBorder( new TitledBorder( "비디오 검색" ) );
        p_east.setLayout( new BorderLayout( ) );
        p_east.add( new JScrollPane( tableVideo ), BorderLayout.CENTER );
        JPanel p_east_north = new JPanel( );
        p_east_north.add( comVideoSearch );   // p_east_north 에 search 2개 붙임
        p_east_north.add( tfVideoSearch );
        p_east.add( p_east_north, BorderLayout.NORTH ); // 붙이기


        // 전체 영역에 붙이기
        setLayout( new GridLayout( 1, 2 ) );
        add( p_west );
        add( p_east );


    }

    //화면에 테이블 붙이는 메소드
    class VideoTableModel extends AbstractTableModel {

        ArrayList data = new ArrayList( );
        String[] columnNames = {"비디오번호", "제목", "장르", "감독", "배우"};

        //=============================================================
        // 1. 기본적인 TabelModel  만들기
        // 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
        // AbstractTabelModel에서 구현되지 않았기에...
        // 반드시 사용자 구현 필수!!!!

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


