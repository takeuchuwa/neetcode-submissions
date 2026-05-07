class Deque {

    private Node head;
    private Node tail;
    private int size;

    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       Node node = new Node();
       node.value = value;
       
       if (size == 0) {
        head = node;
        tail = node;
        size++;
        return;
       }

       tail.next = node;
       node.prev = tail;
       tail = node;
       size++;
    }

    public void appendleft(int value) {
        Node node = new Node();
        node.value = value;
       
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }

        head.prev = node;
        node.next = head;
        head = node;
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        Node node = tail;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        }
        size--;
        return node.value;
    }

    public int popleft() {
        if (size == 0) {
            return -1;
        }
        Node node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return node.value;
        
    }

    private static class Node {
        private int value;
        private Node next;
        private Node prev;
    }
}
