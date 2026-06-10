class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> sumCounter = new HashMap<>();
        sumCounter.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans += sumCounter.getOrDefault(sum - k, 0);
            sumCounter.merge(sum, 1, Integer::sum);
            
        }

        return ans;
    }
}