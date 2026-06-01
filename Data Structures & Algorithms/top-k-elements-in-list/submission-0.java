class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] bucketCounter = new int[2001];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                bucketCounter[Math.abs(nums[i]) + 1000]++;
            } else {
                bucketCounter[nums[i]]++;
            }
        }

        int[] ans = new int[k];

        for (int count = 0; count < k; count++) {
            int maxFreq = -1;
            int maxIndex = 0;
            for (int i = 0; i < bucketCounter.length; i++) {
                if (bucketCounter[i] > maxFreq) {
                    maxFreq = bucketCounter[i];
                    maxIndex = i;
                }
            }

            if (maxIndex > 1000) {
                ans[count] = -(maxIndex - 1000); 
            } else {
                ans[count] = maxIndex;
            }

            bucketCounter[maxIndex] = -1; 
        }
        
        return ans;
    }
}
