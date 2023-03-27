public class SimleList {
    private class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private void checkEmpty() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public SimleList(){
        head = null;
        tail = null;
        size = 0;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int data) {
        Node temp = new Node(data);

        if (isEmpty())
            tail = temp;
        else
            head.prev = temp;

        temp.next = head;
        head = temp;
        size++;
    }

    public void addLast(int data) {
        Node temp = new Node(data);

        if (isEmpty())
            head = temp;
        else
            tail.next = temp;

        temp.prev = tail;
        tail = temp;
        size++;
    }

    public void addByIndex(int data, int index) {
        Node curr = getNode(index);
        Node temp = new Node(data);

        curr.prev.next = temp;
        temp.prev = curr.prev;
        curr.prev = temp;
        temp.next = curr;

        size++;
    }

    public void removeFirst() throws SimpleLinkedListException {
        checkEmpty();

        Node temp = head;

        if (head.next == null){
            tail = null;
        }
        else {
            head.next.prev = null;
        }

        head = head.next;
        size--;
    }

    public void removeLast() throws SimpleLinkedListException {
        checkEmpty();

        Node temp = head;

        if (head.next == null){
            head = null;
        }
        else {
            tail.prev.next = null;
        }

        tail = tail.prev;
        size--;
    }

    public void removeByIndex(int index) throws SimpleLinkedListException {
        checkEmpty();

        Node removed = getNode(index);
        if (index > 1 && index < size) {
            removed.prev.next = removed.next;
            removed.next.prev = removed.prev;
        } else if (index == 1) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        }
        size--;
    }

    public Node getNode(int k) {
        if (isEmpty() || k <= 0 || k > size) {
            return null;
        }
        Node curr;
        int mid = size / 2;
        if (k <= mid) {
            curr = head;
            for (int i = 1; i < k; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size; i > k; i--) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    public int get(int s){
        Node ss = getNode(s);
        return ss.data;
    }

    public int size() {
        return size;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void sortSimpleList() throws SimpleLinkedListException {
        checkEmpty();
        Node temp;
        int otr = 0;
        int nul = 0;
        for (int i = 1; i <= size; i++) {
            if (i == size){
                if (getNode(i).data < 0){
                    temp = getNode(i);
                    addByIndex(temp.data, otr);
                    removeLast();
                    otr++;
                    nul++;
                } else if (getNode(i).data == 0) {
                    temp = getNode(i);
                    addByIndex(temp.data, nul);
                    removeLast();
                    nul++;
                }
            } else if (getNode(i).data < 0) {
                temp = getNode(i);
                addByIndex(temp.data, otr);
                removeByIndex(i);
                otr++;
                nul++;
            } else if (getNode(i).data == 0) {
                temp = getNode(i);
                addByIndex(temp.data, nul);
                removeByIndex(i);
                nul++;
            }
        }
    }
}
