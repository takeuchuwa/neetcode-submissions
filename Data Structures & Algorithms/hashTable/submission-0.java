class HashTable {
    Node[] buckets;
    int size;

    public HashTable(int capacity) {
        buckets = new Node[capacity];
    }

    public void insert(int key, int value) {
        int index = key % buckets.length;
        Node cur = buckets[index];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        cur =  cur != null && cur.key == key ? cur : null;
        if (cur != null) {
            cur.value = value;
        } else {
            if (++size >= buckets.length * 0.5) {
                resize();
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
    }

    public int get(int key) {
        int index = key % buckets.length;
        Node cur = buckets[index];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        return cur == null ? -1 : cur.value;
    }

    public boolean remove(int key) {
        int index = key % buckets.length;
        Node cur = buckets[index];
        if (cur != null) {
            if (cur.key == key) {
                buckets[index] = cur.next;
            } else {
                while (cur.next != null && cur.next.key != key) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }
            size--;
            return true;
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return buckets.length;
    }

    public void resize() {
        Node[] oldBuckets = buckets;
        buckets = new Node[buckets.length * 2];
        for (int i = 0; i < oldBuckets.length; i++) {
            Node cur = oldBuckets[i];
            while (cur != null) {
                Node next = cur.next;
                int index = cur.key % buckets.length;
                cur.next = buckets[index];
                buckets[index] = cur;
                cur = next;
            }
        }
    }

    static class Node {
        int key;
        int value;
        Node next;
    }
}
