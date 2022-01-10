public class LinkedListElement {
    VideoInfo videoData;
    LinkedListElement myNext;

    public LinkedListElement(VideoInfo videoData, LinkedListElement myNext) {
        this.videoData = videoData;
        this.myNext = myNext;
    }

    public VideoInfo getVideoData() {
        return videoData;
    }

    public LinkedListElement getMyNext() {
        return myNext;
    }

    public void setMyNext(LinkedListElement myNext) {
        this.myNext = myNext;
    }
}
