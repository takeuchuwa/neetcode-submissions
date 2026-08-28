class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int n = nums.length;
        int[] max = new int[n - (k - 1)];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek() < left) {
                priorityQueue.poll();
            }
            priorityQueue.offer(right);
            if (right - left == k - 1) {
                max[left] = nums[priorityQueue.peek()];
                left++;
            }
        }

        return max;
    }
}
