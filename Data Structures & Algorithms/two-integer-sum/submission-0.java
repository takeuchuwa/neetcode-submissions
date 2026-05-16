class Solution {
    public int[] twoSum(int[] nums, int target) {
        int targetCapacity = (int) (nums.length * 0.75f) + 1;

        int capacity = 1;
        while (capacity < targetCapacity) {
            capacity <<= 1;
        }

        Node[] buckets = new Node[capacity];
        int mask = capacity - 1;

        for (int i = 0; i < nums.length; i++) {
            int index = index(nums[i], mask);
            
            
            Node cur = buckets[index];
            while (cur != null) {
                if (cur.key == nums[i]) {
                    return new int[]{cur.val, i};
                }
                cur = cur.next;
            }

            int remains = target - nums[i];
            int remainingIndex = index(remains, mask);
            Node newNode = new Node(remains, i);
            newNode.next = buckets[remainingIndex];
            buckets[remainingIndex] = newNode;
        }

        return new int[2];
    }

    private int index(int num, int mask) {
        int hash = num ^ (num >>> 16);
        int index = hash & mask; 
        return index;
    }

    static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
