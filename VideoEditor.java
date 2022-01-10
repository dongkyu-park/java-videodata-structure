public class VideoEditor {
    LinkedListElement startElement;
    LinkedListElement endElement;
    int totalPlayTime;
    int linkedSize;

    public VideoEditor() {
        this.startElement = null;
        this.endElement = null;
        this.totalPlayTime = 0;
        this.linkedSize = 0;
    }

    public void addDataLast(LinkedListElement newElement) { // add logic
        if (isEmpty()) {
            this.startElement = newElement;
            this.endElement = newElement;
            this.totalPlayTime += newElement.getVideoData().getPlayTime();
            this.linkedSize++;
            return;
        }

        this.endElement.setMyNext(newElement);
        this.endElement = newElement;
        this.totalPlayTime += newElement.getVideoData().getPlayTime();
        this.linkedSize++;
    }

    public void addDataFirst(LinkedListElement newElement) {
        if (isEmpty()) {
            this.startElement = newElement;
            this.endElement = newElement;
            this.totalPlayTime += newElement.getVideoData().getPlayTime();
            this.linkedSize++;
            return;
        }

        this.startElement.setMyNext(newElement);
        this.startElement = newElement;
        this.totalPlayTime += newElement.getVideoData().getPlayTime();
        this.linkedSize++;
    }

    public void addDataToPoint(LinkedListElement newElement, int point) { // insert logic
        if (point < 0) {
            Message.ERROR_ILLEGAL_VALUE.printMessage();
            return;
        }

        if (isEmpty()) {
            addDataFirst(newElement);
            return;
        }

        if (this.linkedSize <= point) { // 순서값이 현재 링크드 리스트의 갯수보다 같거나 큰 경우
            addDataLast(newElement);
            return;
        }

        if (point == 0) { // 순서값이 0인 경우 첫번째 데이터로 추가
            addDataFirst(newElement);
            return;
        }

        LinkedListElement nextElement = this.startElement;
        LinkedListElement prevElement = null;

        for (int i = 0; i < point; i++) {
            prevElement = nextElement;
            nextElement = prevElement.getMyNext();
        }

        newElement.setMyNext(nextElement);
        prevElement.setMyNext(newElement);
        this.totalPlayTime += newElement.getVideoData().getPlayTime();
        this.linkedSize++;

        if (nextElement == null) {
            this.endElement = newElement;
        } // nextData가 null인 경우는, 데이터를 추가한 point가 마지막 데이터 라는 의미이므로
        // 추가한 데이터를 마지막 데이터로 지정
    }

    public void deleteData(String selectedVideoId) { // delete logic
        if (isEmpty()) {
            return;
        }

        LinkedListElement nowElement = this.startElement;
        LinkedListElement prevElement = null;

        for (int i = 0; i < this.linkedSize; i++) {
            if (nowElement.getVideoData().getId().equals(selectedVideoId)) {
                if (prevElement == null) {
                    this.startElement = nowElement.getMyNext();
                    this.totalPlayTime -= nowElement.getVideoData().getPlayTime();
                    this.linkedSize--;
                    break;
                } // 이전 요소가 null인 경우는, 탐색을 시작한 요소가 첫번째 라는 의미이므로
                // 삭제할 요소의 다음 요소를 첫번째 로 지정

                prevElement.setMyNext(nowElement.getMyNext());
                this.totalPlayTime -= nowElement.getVideoData().getPlayTime();
                this.linkedSize--;

                if (nowElement.getMyNext() == null) {
                    this.endElement = prevElement;
                } // 삭제할 요소의 다음 요소가 null인 경우는, 삭제할 요소가 마지막 이라는 의미 이므로
                // 삭제할 요소의 이전 요소를 마지막 으로 지정

                nowElement = null;
                break;
            }

            prevElement = nowElement;
            nowElement = prevElement.getMyNext();
        }
    }

    private boolean isEmpty() {
        if (this.startElement == null) {
            return true;
        }

        return false;
    }

    public LinkedListElement getStartElement() {
        return startElement;
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    public int getLinkedSize() {
        return linkedSize;
    }
}
