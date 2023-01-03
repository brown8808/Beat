package dynamic_beat_1;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread {
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
    private int x, y; // 현재 노트의 위치 파악
    private String noteType;

    public Note(int x, int y, String noteType) { // 현재 노트가 만들어질 위치에 만들어줌, 생성자
        this.x = x; // 각각의 변수를 초기화
        this.y = y;
        this.noteType = noteType;
    }
    public void screenDraw(Graphics2D g) { // 노트에 대한 이미지를 그릴 수 있도록 스크린드로우를 만듬
        if (noteType.equals("short")) // 짧은 노트라면
        {
            g.drawImage(noteBasicImage, x, y, null);
        }
        else if (noteType.equals("long")) // 스페이스바용 긴 노트를 생성
        {
            g.drawImage(noteBasicImage, x, y, null);
            g.drawImage(noteBasicImage, x + 100, y, null);
        }
    }
    public void drop() {
        y += Main.NOTE_SPEED;
    }
    @Override
    public void run() { // 쓰레드의 실행을 위한 함수
        try {
            while (true) {
                drop();
                Thread.sleep(Main.SLEEP_TIME);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
