class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        int targetCapacity = (int) (nums.length / 0.75f) + 1;

        int capacity = 1;
        while (capacity < targetCapacity) {
            capacity <<= 1;
        }

        Node[] buckets = new Node[capacity];
        int mask = capacity - 1;

        for (int num : nums) {
            int hash = num ^ (num >>> 16);
            
            int index = hash & mask; 
            
            Node curr = buckets[index];
            while (curr != null) {
                if (curr.val == num) {
                    return true;
                }
                curr = curr.next;
            }
            
            Node newNode = new Node(num);
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }

        return false;
    }

    static class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
    }
}