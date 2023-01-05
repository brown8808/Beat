package dynamic_beat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// 프로그램 안의 작은 프로그램
public class Game extends Thread{
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../image/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../image/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../image/gameInfo.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();

    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();


    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();


    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
        gameMusic.start();
        dropNotes(titleName);
    }


    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 437, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        for (int i = 0; i < noteList.size(); i++)
        {
            Note note = noteList.get(i);
            note.screenDraw(g);
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space", 270, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 997, 609);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);

    }

    public void pressS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }
    public void pressD() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }
    public void releaseD() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }
    public void pressF() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall3.mp3", false).start();
    }
    public void releaseF() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }
    public void pressSpace() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }
    public void releaseSpace() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }
    public void pressJ() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
    }
    public void releaseJ() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }
    public void pressK() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }
    public void releaseK() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }
    public void pressL() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }
    public void releaseL() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    @Override
    public void run() {

    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        noteList.add(new Note(228, 120, "short"));
        noteList.add(new Note(332, 580, "short"));
        noteList.add(new Note(436, 500, "short"));
        noteList.add(new Note(540, 340, "long"));
        noteList.add(new Note(744, 325, "short"));
        noteList.add(new Note(848, 305, "short"));
        noteList.add(new Note(952, 305, "short"));
    }


}
