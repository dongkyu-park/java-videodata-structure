import java.util.HashMap;

public enum Message {
    VIDEO_CLIP___("---영상클립---"), TITLE_NAME("제목"), VIDEO_CLIP("영상클립"), TOTAL_VIDEO_LEN("전체길이"),
    VIEW_CONSOLE("> "), END("편집기를 종료합니다."), ERROR_ILLEGAL_VALUE("순서값은 0 이상의 값이 입력되어야 합니다.");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void printMessageWithoutLineBreak() {
        System.out.print(message);
    }

    public void printMessageWithClipSize(int clipSize) {
        System.out.println(message + ": " + clipSize + "개");
    }

    public void printMessageWithTotalVideoLen(int totalVideoLen) {
        System.out.println(message + ": " + totalVideoLen + "sec");
    }

    public void printMessageVideoEditorInfo(VideoEditor videoEditor) {
        System.out.print("|");
        Node node = videoEditor.getStartNode();
        while (node != null) {
            System.out.print("---[" + node.getVideoData().getId() + ", " + node.getVideoData().getPlayTime() + "sec]");
            node = node.getNextNode();
        }
        System.out.println("---[end]");
    }

    public void printViedoInfo(HashMap<String, VideoInfo> idLinkedVideoInfo) {
        idLinkedVideoInfo.forEach((id, videoInfo) -> {
            videoInfo.printViedoInfo();
        });
    }

    public String getMessage() {
        return message;
    }
}
