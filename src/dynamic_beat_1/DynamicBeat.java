package dynamic_beat_1;

import javax.swing.*;
import java.awt.*;

// JFrame 은 GUI 기반의 프로그램을 만들기 위한 라이브러리
public class DynamicBeat extends JFrame {

    // 더블 버퍼링을 위한 두 인스턴스
    private Image screenImage;
    private Graphics screenGraphic;

    // 인트로 백그라운드를 담을 수있는 객체
    private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
    public DynamicBeat() {
        setTitle("Dynamic Beat"); // 게임 이름 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 게임창은 크기 설정이 불가
        setLocationRelativeTo(null); // 게임창이 컴퓨터 중앙으로
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창 종료시 프로그램도 같이 종료
        setVisible(true); // 게임창이 화면에 출력되도록 설정

        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();

    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }



}
