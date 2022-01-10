public class VideoInfo {
    String id;
    String title;
    int playTime;
    VideoInfo nextVideoInfo = null;
    GenerateVideo generateVideo = new GenerateVideo();

    public VideoInfo() {
        this.id = generateVideo.generateRandomId();
    }

    public VideoInfo(String title, int playTime, VideoInfo nextVideoInfo) {
        this.id = generateVideo.generateRandomId();
        this.title = title;
        this.playTime = playTime;
        this.nextVideoInfo = nextVideoInfo;
    }

    public void printViedoInfo() {
        System.out.println(this.title + "(" + this.id + ")" + ":" + this.playTime);
    }

}
