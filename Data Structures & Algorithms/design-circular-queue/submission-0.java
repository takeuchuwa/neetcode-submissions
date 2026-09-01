class MyCircularQueue {

    private int maxSize;
    private int currSize;
    private Node head;
    private Node tail;

    public MyCircularQueue(int k) {
        head = new Node();
        maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if (currSize == maxSize) {
            return false;
        }
        
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        Node enqueue = new Node(value);
        curr.next = enqueue;
        tail = enqueue;
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        if (currSize == 0) {
            return false;
        }

        head.next = head.next.next;
        currSize--;
        if (currSize == 0) {
            tail = null;
        }
        return true;
    }
    
    public int Front() {
        return head.next == null ? -1 : head.next.value;
    }
    
    public int Rear() {
        return tail == null ? -1 : tail.value;
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == maxSize;
    }

    private static class Node {
        private int value;
        private Node next;

        private Node(){}

        private Node(int value) {
            this.value = value;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */