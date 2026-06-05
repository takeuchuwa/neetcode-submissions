class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int sum = 0;
        int target = k * threshold;
        for (int i = 0; i < k - 1 && i < n; i++) {
            sum += arr[i];
        }
        int i = k - 1;
        while (i < n) {
            sum += arr[i];
            if (sum >= target) {
                ans++;
            }
            i++;
            sum -= arr[i - k];
        }

        return ans;
    }
}