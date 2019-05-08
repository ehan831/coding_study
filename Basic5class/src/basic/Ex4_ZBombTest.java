package basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex4_ZBombTest extends JFrame {
    private JPanel p1, p2;
    private JButton btn;
    private JLabel lb, image;
    private boolean inputChk;

    Ex4_ZBombTest() {
        setTitle( "폭탄 테스트!" );
        p1 = new JPanel( );
        p1.add( btn = new JButton( "시작" ) );
        p1.add( lb = new JLabel( "카운트다운" ) );
        add( p1, "North" );
        p2 = new JPanel( );
        p2.add( image = new JLabel( new ImageIcon( "Basic5class/src/basic/imgs/bomb_2.jpg" ) ) );

        add( p2, "Center" );
        setBounds( 200, 200, 600, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );

        btn.addActionListener( new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {

                // 1- 카운트 다운을 시작하는 스레드
                new Thread( new Runnable( ) {
                    @Override
                    public void run() {
                        for (int i = 10; i > 0; i--) {
                            if (inputChk) {
                                inputChk = false;
                                System.out.println( "빙고" );
                                return;
                            }
                            if (i == 1) image.setIcon( new ImageIcon( "./imgs/bomb_3.jpg" ) );
                            lb.setText( String.valueOf( i ) );
                            try {
                                Thread.sleep( 1000 );
                            } catch (InterruptedException e1) {
                                e1.printStackTrace( );
                            }
                        }
                    }
                } ).start( );

                // 2- 암호값을 입력받기
                new Thread( new Runnable( ) {
                    @Override
                    public void run() {
                        String secret = "1234";
                        String answer = JOptionPane.showInputDialog( "암호를 대시오" );
                        if (secret.equals( answer )) {
                            inputChk = true;
                        }
                    }
                } ).start( );
            }
        } );
    }

    public static void main(String[] args) {
        new Ex4_ZBombTest( );
    }
}
