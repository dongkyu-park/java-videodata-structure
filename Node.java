public class Node {
    VideoInfo videoData;
    Node nextNode;

    public Node(VideoInfo videoData) {
        this.videoData = videoData;
        this.nextNode = null;
    }

    public VideoInfo getVideoData() {
        return videoData;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
