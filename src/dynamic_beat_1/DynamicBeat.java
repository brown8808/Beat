package dynamic_beat_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// JFrame 은 GUI 기반의 프로그램을 만들기 위한 라이브러리
public class DynamicBeat extends JFrame {

    // 더블 버퍼링을 위한 두 인스턴스
    private Image screenImage;
    private Graphics screenGraphic;

    private  ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
    private  ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

    // 인트로 백그라운드를 담을 수있는 객체
    private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
    private JButton exitButton = new JButton(exitButtonBasicImage);

    private int mouseX, mouseY;

    public DynamicBeat() {
        setUndecorated(true);
        setTitle("Dynamic Beat"); // 게임 이름 설정
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 게임창은 크기 설정이 불가
        setLocationRelativeTo(null); // 게임창이 컴퓨터 중앙으로
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창 종료시 프로그램도 같이 종료
        setVisible(true); // 게임창이 화면에 출력되도록 설정
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseMotionListener((new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor((new Cursor(Cursor.HAND_CURSOR)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor((new Cursor(Cursor.DEFAULT_CURSOR)));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        }));

        add(exitButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener((new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseY, y - mouseY);
            }
        }));
        add(menuBar);

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
