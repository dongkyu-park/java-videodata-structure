public class VideoEditor {
    Node startNode;
    Node endNode;
    int totalPlayTime;
    int linkedSize;

    public VideoEditor() {
        this.startNode = null;
        this.endNode = null;
        this.totalPlayTime = 0;
        this.linkedSize = 0;
    }

    public void addDataLast(Node newNode) { // add logic
        if (isEmpty()) {
            this.startNode = newNode;
            this.endNode = newNode;
            this.totalPlayTime += newNode.getVideoData().getPlayTime();
            this.linkedSize++;
            return;
        }

        this.endNode.setNextNode(newNode);
        this.endNode = newNode;
        this.totalPlayTime += newNode.getVideoData().getPlayTime();
        this.linkedSize++;
    }

    public void addDataFirst(Node newNode) {
        if (isEmpty()) {
            this.startNode = newNode;
            this.endNode = newNode;
            this.totalPlayTime += newNode.getVideoData().getPlayTime();
            this.linkedSize++;
            return;
        }

        this.startNode.setNextNode(newNode);
        this.startNode = newNode;
        this.totalPlayTime += newNode.getVideoData().getPlayTime();
        this.linkedSize++;
    }

    public void addDataToPoint(Node newNode, int point) { // insert logic
        if (point < 0) {
            Message.ERROR_ILLEGAL_VALUE.printMessage();
            return;
        }

        if (isEmpty()) {
            addDataFirst(newNode);
            return;
        }

        if (this.linkedSize <= point) { // 순서값이 현재 링크드 리스트의 갯수보다 같거나 큰 경우
            addDataLast(newNode);
            return;
        }

        if (point == 0) { // 순서값이 0인 경우 첫번째 데이터로 추가
            addDataFirst(newNode);
            return;
        }

        Node prevNode = null;
        // --> newNode가 0번째 point로 추가될 때로 초기화
        Node nextNode = this.startNode;

        for (int i = 0; i < point; i++) {
            prevNode = nextNode;
            nextNode = prevNode.getNextNode();
        }

        newNode.setNextNode(nextNode);
        prevNode.setNextNode(newNode);
        this.totalPlayTime += newNode.getVideoData().getPlayTime();
        this.linkedSize++;

        if (nextNode == null) {
            this.endNode = newNode;
        } // nextNode가 null인 경우는, 노드를 추가한 point가 마지막 노드 라는 의미이므로
        // 추가한 노드를 마지막 노드로 지정
    }

    public void deleteData(String selectedVideoId) { // delete logic
        if (isEmpty()) {
            return;
        }

        Node currentNode = this.startNode;
        Node prevNode = null;

        for (int i = 0; i < this.linkedSize; i++) {
            if (currentNode.getVideoData().getId().equals(selectedVideoId)) {
                if (prevNode == null) { // 첫번째 노드 삭제 체크
                    this.startNode = currentNode.getNextNode();
                    this.totalPlayTime -= currentNode.getVideoData().getPlayTime();
                    this.linkedSize--;
                    break;
                } // 이전 노드가 null인 경우는, 탐색을 시작한 노드가 첫번째 라는 의미이므로
                // 삭제할 노드의 다음 노드를 첫번째 로 지정

                prevNode.setNextNode(currentNode.getNextNode());
                this.totalPlayTime -= currentNode.getVideoData().getPlayTime();
                this.linkedSize--;

                if (currentNode.getNextNode() == null) { // 마지막 노드 삭제 체크
                    this.endNode = prevNode;
                } // 삭제할 노드의 다음 노드가 null인 경우는, 삭제할 노드가 마지막 이라는 의미 이므로
                // 삭제할 노드의 이전 노드를 마지막 으로 지정

                currentNode = null;
                break;
            }

            prevNode = currentNode;
            currentNode = prevNode.getNextNode();
        }
    }

    private boolean isEmpty() {
        if (this.startNode == null) {
            return true;
        }

        return false;
    }

    public Node getStartNode() {
        return startNode;
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    public int getLinkedSize() {
        return linkedSize;
    }
}
