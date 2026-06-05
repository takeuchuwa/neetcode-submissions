class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> windowNums = new HashSet<>();
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                windowNums.remove(nums[L]);
                L++;
            }
            if (windowNums.contains(nums[R])) {
                return true;
            }
            windowNums.add(nums[R]);
        }

        return false;
    }
}