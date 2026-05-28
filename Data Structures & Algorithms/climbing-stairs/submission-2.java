class Solution {
    public int climbStairs(int n) {
        int[] ans = {0, 1};

        int i = 2;
        while (i <= n) {
            int tmp = ans[1];
            ans[1] = ans[0] + ans[1];
            ans[0] = tmp;
            i++;
        }

        return ans[1] + ans[0];
    }
}
