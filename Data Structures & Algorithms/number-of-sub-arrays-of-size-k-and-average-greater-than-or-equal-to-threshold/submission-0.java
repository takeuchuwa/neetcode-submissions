class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        
        int ans = 0;
        double sum = 0;
        for (int i = 0; i < k && i < n; i++) {
            sum += arr[i];
        }
        int L = 0;
        int R = k;
        if (((double) sum) / k >= threshold) {
            ans++;
        }
        while (L < n - k) {
            sum = sum - arr[L] + arr[R];
            if (((double) sum) / k >= threshold) {
                ans++;
            }
            R++;
            L++;
        }

        return ans;
    }
}