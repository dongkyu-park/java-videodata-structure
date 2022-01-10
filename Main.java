import java.util.HashSet;

public class Main {
    public static final int HOW_MUCH = 13;

    public static void main(String[] args) {
        GenerateVideo generateVideo = new GenerateVideo();
        generateVideo.generateRandomId();
        Message.VIDEO_CRIP.sendMessage();
        generateSampleVideo();
    }

    public static void generateSampleVideo() {
        for (int i = 1; i <= HOW_MUCH; i++) {
            String title = "제목" + i;
            int playTime = (int)(Math.random() * 15) + 1;

            VideoInfo videoInfo = new VideoInfo(title, playTime, null);
            videoInfo.printViedoInfo();
        }
    }

}
