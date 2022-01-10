public enum Message {
    VIDEO_CRIP("---영상클립---");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public void sendMessage() {
        System.out.println(message);
    }
}
