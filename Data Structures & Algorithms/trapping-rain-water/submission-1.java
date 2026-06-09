class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int maxLSeen = height[0];
        int[] maxL = new int[n];
        for (int i = 1; i < n; i++) {
            maxL[i] = maxLSeen;
            maxLSeen = Math.max(height[i], maxLSeen);
        }

        int maxRSeen = height[n - 1];
        int[] maxR = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = maxRSeen;
            maxRSeen = Math.max(height[i], maxRSeen);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(maxR[i], maxL[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }

        return ans;
    }
}
