class LinkedList {

    private Node head;
    private Node tail;
    private int size;


    public LinkedList() {
    }

    public int get(int index) {
        if (index >= size) 
            return -1;
        
        int i = 0;
        Node cur = head;
        while (i != index) {
            cur = cur.next;
            i++;
        }

        return cur.value;
    }

    public void insertHead(int val) {
        Node node = new Node();
        node.value = val;
        node.next = head;
        head = node;
        if (size == 0)
            tail = node;

        size++;
    }

    public void insertTail(int val) {
        Node node = new Node();
        node.value = val;
        if (tail != null)
            tail.next = node;

        tail = node;

        if (size == 0)
            head = node;

        size++;
    }

    public boolean remove(int index) {
        if (index >= size || index < 0) 
            return false;
        
        if (index == 0) {
            head = head.next;
        } else {
            int findIndex = index - 1;
            int i = 0;
            Node prevElement = head;
            while (i != findIndex) {
                prevElement = prevElement.next;
                i++;
            }

            prevElement.next = prevElement.next.next;

            if (index == size - 1) {
                tail = prevElement;
            }
        }

        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {     
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur.value);
            cur = cur.next;
        }

        return list;
    }

    private static class Node {
        private int value;
        private Node next;
    }
}
