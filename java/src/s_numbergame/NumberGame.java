package s_numbergame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame {
    public static void main(String[] args) {
        MyFrame f = new MyFrame( );
        f.initChar( );
        f.showAnswer( );
    }
}

class MyFrame extends JFrame implements ActionListener {

    private int getsu = 4;
    private JButton[][] la;

    private char[][] answer = new char[getsu][getsu];

    // 첫 번쨰 버튼
    private JButton firstClick;
    private int firstRow, firstCol;

    MyFrame() {
        //객체 생성
        la = new JButton[getsu][getsu];


        //화면 출력
        setLayout( new GridLayout( 4, 4 ) );
        for (int i = 0; i < la.length; i++) {
            for (int j = 0; j < la[i].length; j++) {
                la[i][j] = new JButton( );
                add( la[i][j] );
                la[i][j].addActionListener( this );
                answer[i][j] = '0'; // 문자 초기화
            }
        }

        setSize( 500, 500 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    void showAnswer() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                la[i][j].setText( String.valueOf( answer[i][j] ) );
            }
        }
//        try {
//            Thread.sleep( 2000 );
//        } catch (Exception e) {
//        }
//
//        for (int i = 0; i < answer.length; i++) {
//            for (int j = 0; j < answer[i].length; j++) {
//                la[i][j].setText( null );
//            }
//        }
    }

    void initChar() {
        char alpha = '0';

        RESTART:
        for (int i = 0; i < getsu * getsu; ) {
            if (i % 2 == 0) {
                alpha = (char) ('A' + (int) (Math.random( ) * 26));
                for (char[] chars : answer) {
                    for (char aChar : chars) {
                        if (aChar == alpha) {
                            continue RESTART;
                        }
                    }
                }
            }
            //임의의 자리에 알파벳 넣기
            boolean ok = false;
            do {
                int row = (int) (Math.random( ) * getsu);
                int col = (int) (Math.random( ) * getsu);
                if (answer[row][col] == '0') {
                    answer[row][col] = alpha;
                    i++;
                    ok = true;
                }
            } while (!ok);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton obj = (JButton) e.getSource( );
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (obj == la[i][j]) {
                    // 첫 번쨰 버튼 인지
                    if (firstClick == null) {
                        firstClick = obj;
                        firstRow = i;
                        firstCol = j;
                        firstClick.setBackground( Color.BLACK );  // RGB 표현
                    } else {
                        if (answer[i][j]==answer[firstRow][firstCol]) {
                            JOptionPane.showConfirmDialog( null, "딩동댕" );
                        }else {
                            firstClick.setBackground( null );
                        }
                        firstClick=null;
                    }
                }
            }
        }
    }
}


