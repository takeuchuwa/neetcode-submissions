class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        int[] costDays = new int[] {1, 7, 30};
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            int idx = 0;
            int j = i;
            for (int k = 0; k < costs.length; k++) {
                while (j < n && days[j] < days[i] + costDays[k]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], costs[k] + dp[j]);
            }
        }

        return dp[0];
    }

    // private int dfsHelper(int i, int[] days, int[] costs, int[] cache ) {
    //     if (i >= days.length) {
    //         return 0;
    //     }

    //     if (cache[i] != 0) {
    //         return cache[i];
    //     }
        
    //     int val1 = costs[0] + dfsHelper(i + 1, days, costs, cache);
    //     int j;
    //     for (j = i; j < days.length && days[j] < days[i] + 7; j++); 
    //     int val2 = costs[1] + dfsHelper(j, days, costs, cache);
    //     for (; j < days.length && days[j] < days[i] + 30; j++);
    //     int val3 = costs[2] + dfsHelper(j, days, costs, cache); 

    //     cache[i] = Math.min(val1, Math.min(val2, val3));

    //     return cache[i];
    // }
}