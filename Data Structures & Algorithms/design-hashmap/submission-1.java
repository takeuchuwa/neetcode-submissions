class MyHashMap {

    private Node[] buckets;
    private int size;
    public MyHashMap() {
        buckets = new Node[16];
    }
    
    public void put(int key, int value) {
        int hash = hash(key);
        Node curr = buckets[hash];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        if (curr == null) {
            if (++size > buckets.length * 0.75) {
                resize();
            }
            curr = new Node();
            curr.key = key;
            curr.val = value;
            curr.next = buckets[hash];
            buckets[hash] = curr;
            
        } else {
            curr.val = value;
        }

    }

    private void resize() {
        Node[] newBuckets = new Node[buckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            Node curr = buckets[i];
            while (curr != null) {
                Node next = curr.next;
                int hash = hash(curr.key);
                curr.next = buckets[hash];
                buckets[hash] = curr;
                curr = next;
            }
        }

        buckets = newBuckets;
    }
    
    public int get(int key) {
        int hash = hash(key);
        Node curr = buckets[hash];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        return curr != null ? curr.val : -1;
    }
    
    public void remove(int key) {
        int hash = hash(key);
        Node curr = buckets[hash];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        if (curr != null) {
            buckets[hash] = curr.next;
            size--;
        }
    }

    private int hash(int key) {
        int hash = key ^ (key >>> 16);
        int mask = buckets.length - 1;
        return key & mask;
    }

    class Node {
        int key;
        int val;
        Node next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */