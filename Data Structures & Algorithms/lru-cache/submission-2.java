class LRUCache {

    private HashNode[] buckets;
    private int capacity;
    private int size;

    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        int targetCapacity = (int) (capacity * 0.75f) + 1;

        int actualCapacity = 1;
        while (actualCapacity < targetCapacity) {
            actualCapacity <<= 1;
        }

        this.buckets = new HashNode[actualCapacity];

        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = findInBucket(key);
        if (node == null) {
            return -1;
        }
        
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = findInBucket(key);
        
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.val = value;
            
            addToBucket(key, newNode);
            addNodeToHead(newNode);
            size++;
            
            if (size > capacity) {
                ListNode tailNode = popTail();
                removeFromBucket(tailNode.key);
                size--;
            }
        }
    }

    private void addNodeToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private ListNode popTail() {
        ListNode realTail = tail.prev;
        removeNode(realTail);
        return realTail;
    }

    private ListNode findInBucket(int key) {
        int index = hash(key);
        HashNode cur = buckets[index];
        while (cur != null) {
            if (cur.node.key == key) {
                return cur.node;
            }
            cur = cur.next;
        }
        return null;
    }

    private void addToBucket(int key, ListNode node) {
        int index = hash(key);
        HashNode newHashNode = new HashNode();
        newHashNode.node = node;
        newHashNode.next = buckets[index];
        buckets[index] = newHashNode;
    }

    private void removeFromBucket(int key) {
        int index = hash(key);
        HashNode cur = buckets[index];
        
        if (cur == null) return;

        if (cur.node.key == key) {
            buckets[index] = cur.next;
            return;
        }

        while (cur.next != null && cur.next.node.key != key) {
            cur = cur.next;
        }

        if (cur.next != null) {
            cur.next = cur.next.next;
        }
    }

    private int hash(int key) {
        key = key ^ (key >>> 16);
        int mask = buckets.length - 1;
        return key & mask;
    }

    static class HashNode {
        ListNode node;
        HashNode next;
    }

    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
    }
}