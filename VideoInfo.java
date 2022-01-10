public class VideoInfo {
    String id;
    String title;
    int playTime;
    LinkedListElement nextElement;

    public VideoInfo(String title, int playTime, LinkedListElement nextElement, GenerateId generateId) {
        this.id = generateId.generateRandomId();
        this.title = title;
        this.playTime = playTime;
        this.nextElement = nextElement;
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

    public LinkedListElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(LinkedListElement nextElement) {
        this.nextElement = nextElement;
    }
}
