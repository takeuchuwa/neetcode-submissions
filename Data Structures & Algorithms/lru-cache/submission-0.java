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
    }
    
    public int get(int key) {
        int index = hash(key);
        HashNode cur = buckets[index];
        while (cur != null) {
            if (cur.node.key == key) {
                break;
            }
            cur = cur.next;
        }
        
        if (cur != null && cur.node != head) {
            ListNode node = cur.node;
            if (node != tail) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
                tail.next = null;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        
        return cur != null ? cur.node.val : -1;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        HashNode cur = buckets[index];
        while (cur != null && cur.node.key != key) {
            cur = cur.next;
        }
        if (cur == null) {
            HashNode newNode = new HashNode();
            ListNode listNode = new ListNode();
            listNode.key = key;
            listNode.val = value;
            newNode.node = listNode;
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
            if (head == null) {
                head = listNode;
                tail = listNode;
            } else {
                listNode.next = head;
                head.prev = listNode;
                head = listNode;
            }
            
            if (size > capacity) {
                int tailIndex = hash(tail.key);
                HashNode curTail = buckets[tailIndex];
                if (curTail.node.key == tail.key) {
                    buckets[tailIndex] = curTail.next;
                } else {
                    while (curTail.next != null && curTail.next.node.key != tail.key) {
                        curTail = curTail.next;
                    }
                    curTail.next = curTail.next.next;
                }
                
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            ListNode recentlyUsed = cur.node;
            recentlyUsed.val = value;
            if (recentlyUsed != head) {
                ListNode prev = recentlyUsed.prev;
                prev.next = recentlyUsed.next;
                if (recentlyUsed == tail) {
                    tail = prev;
                } else {
                    ListNode next = recentlyUsed.next;
                    next.prev = prev;
                }
                
                recentlyUsed.next = head;
                recentlyUsed.prev = null;
                head.prev = recentlyUsed;
                head = recentlyUsed;
            }
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
