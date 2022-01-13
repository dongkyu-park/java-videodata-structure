public class VideoInfo {
    String id;
    String title;
    int playTime;
    Node nextNode;

    public VideoInfo(String title, int playTime, idManager idManager) {
        this.id = idManager.generateRandomId();
        this.title = title;
        this.playTime = playTime;
        this.nextNode = null;
    }

    public void printViedoInfo() {
        System.out.println(this.title + "(" + this.id + ")" + ":" + this.playTime);
    }

    public String getId() {
        return id;
    }

    public int getPlayTime() {
        return playTime;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
