public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n - (k - 1)];
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
                queue.removeLast();
            }
            queue.addLast(right);

            if (left > queue.getFirst()) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                max[left] = nums[queue.getFirst()];
                left++;
            }
        }

        return max;
    }
}