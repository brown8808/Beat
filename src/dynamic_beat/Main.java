package dynamic_beat;



public class Main {
    // 퍼블릭 스테틱은 모든 프로젝트에서 공유할 수 있는 변수
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final int NOTE_SPEED = 7;
    public static final int SLEEP_TIME = 10;
    public static void main(String[] args) {

        new DynamicBeat();

    }

}
