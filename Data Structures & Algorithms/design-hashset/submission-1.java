class MyHashSet {

    private Node[] set;
    private int size;
    public MyHashSet() {
        set = new Node[16];
    }
    
    public void add(int key) {
        int hash = hash(key);
        Node curr = set[hash];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        if (curr == null) {
            curr = new Node();
            curr.key = key;
            curr.next = set[hash];
            set[hash] = curr;
            if (++size * 0.75 > set.length) {
                resize();
            }
        }
    }

    private void resize() {
        Node[] oldSet = set;
        set = new Node[set.length * 2];
        for (int i = 0; i < oldSet.length; i++) {
            Node curr = oldSet[i];
            while (curr != null) {
                Node next = curr.next;
                int hash = hash(curr.key);
                curr.next = set[hash];
                set[hash] = curr;
                curr = next;
            }
        }
    }
    
    public void remove(int key) {
        int hash = hash(key);
        Node prev = null;
        Node curr = set[hash];
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        } 

        if (curr != null) {
            if (prev != null) {
                prev.next = prev.next.next;
            } else {
                set[hash] = curr.next;
            }
        }
    }

    private int hash(int key) {
        int hash = key ^ (key >>> 16);
        int mask = set.length - 1;
        return hash & mask;
    }
    
    public boolean contains(int key) {
        int hash = hash(key);
        Node curr = set[hash];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        return curr != null;
    }

    class Node {
        int key;
        Node next;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */