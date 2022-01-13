import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    private static final int HOW_MUCH = 13;
    private static final int MIN_PLAY_TIME = 1;
    private static final int MAX_PLAY_TIME = 15;

    public static void main(String[] args) {
        HashMap<String, VideoInfo> idLinkedVideoMap = new LinkedHashMap<>();
        VideoEditor videoEditor = new VideoEditor();

        Message.VIDEO_CLIP___.printMessage(); // ---영상클립--- 메세지
        generateSampleVideo(idLinkedVideoMap);

        Scanner sc = new Scanner(System.in);

        while (true) {
            Message.VIEW_CONSOLE.printMessageWithoutLineBreak(); // 콘솔창 > 표시
            String commandLine = sc.nextLine();
            String[] commandArr = commandLine.split(" ");
            String command = commandArr[0];
            String id = "";

            if (command.equals("add")) {
                id = commandArr[1];
                if (idLinkedVideoMap.containsKey(id)) {
                    videoEditor.addDataLast(new Node(idLinkedVideoMap.get(id)));
                }

                Message.VIEW_CONSOLE.printMessageVideoEditorInfo(videoEditor);
                continue;
            }

            if (command.equals("insert")) {
                id = commandArr[1];
                int point = Integer.parseInt(commandArr[2]);

                if (idLinkedVideoMap.containsKey(id)) {
                    videoEditor.addDataToPoint(new Node(idLinkedVideoMap.get(id)), point);
                }

                Message.VIEW_CONSOLE.printMessageVideoEditorInfo(videoEditor);
                continue;
            }

            if (command.equals("delete")) {
                id = commandArr[1];
                videoEditor.deleteData(id);
                Message.VIEW_CONSOLE.printMessageVideoEditorInfo(videoEditor);
                continue;
            }

            if (command.equals("render")) {
                Message.VIDEO_CLIP.printMessageWithClipSize(videoEditor.getLinkedSize());
                Message.TOTAL_VIDEO_LEN.printMessageWithTotalVideoLen(videoEditor.getTotalPlayTime());
                continue;
            }

            if (command.equals("exit")) {
                Message.END.printMessage();
                break;
            }
        }
    }

    public static void generateSampleVideo(HashMap<String, VideoInfo> idLinkedVideoInfo) {
        idManager idManager = new idManager();

        for (int i = 1; i <= HOW_MUCH; i++) {
            String title = Message.TITLE_NAME.getMessage() + i;
            int playTime = (int)(Math.random() * MAX_PLAY_TIME) + MIN_PLAY_TIME;

            VideoInfo videoInfo = new VideoInfo(title, playTime, idManager);
            idLinkedVideoInfo.put(videoInfo.getId(), videoInfo);
        }

        Message.VIEW_CONSOLE.printViedoInfo(idLinkedVideoInfo);
    }
}
