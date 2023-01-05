package dynamic_beat;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread {
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
    private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
    private String noteType;
    private boolean proceeded = true;

    public String getNoteType() {
        return noteType;
    }

    public boolean isProceeded() {
        return proceeded;
    }

    public void close() {
        proceeded = false;
    }


    public Note(String noteType) { // 현재 노트가 만들어질 위치에 만들어줌, 생성자
        if (noteType.equals("S")) {
            x = 228;
        }
        else if (noteType.equals("D")) {
            x = 332;
        }
        else if (noteType.equals("F")) {
            x = 436;
        }
        else if (noteType.equals("Space")) {
            x = 540;
        }
        else if (noteType.equals("J")) {
            x = 744;
        }
        else if (noteType.equals("K")) {
            x = 848;
        }
        else if (noteType.equals("L")) {
            x = 952;
        }
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
        if (y > 620) {
            System.out.println("Miss");
            close();
        }
    }
    @Override
    public void run() { // 쓰레드의 실행을 위한 함수
        try {
            while (true) {
                drop();
                if (proceeded) {
                    Thread.sleep(Main.SLEEP_TIME);
                } else {
                    interrupt();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public  String judge() {
        if (y >= 613) {
            System.out.println("Late");
            close();
            return "Late";
        }
        else if (y >= 600) {
            System.out.println("Good");
            close();
            return "Good";
        }
        else if (y >= 600) {
            System.out.println("Great");
            close();
            return "Great";
        }
        else if (y >= 600) {
            System.out.println("Perfect");
            close();
            return "Perfect";
        }
        else if (y >= 600) {
            System.out.println("Good");
            close();
            return "Good";
        }
        else if (y >= 600) {
            System.out.println("Early");
            close();
            return "Early";
        }
        return "None";
    }

    public int getY() {
        return y;
    }

}
