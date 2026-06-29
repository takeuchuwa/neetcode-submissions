class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] canNotBeJudge = new boolean[n];
        int[] trustCount = new int[n];
        for (int i = 0; i < trust.length; i++) {
            canNotBeJudge[trust[i][0] - 1] = true;
            trustCount[trust[i][1] - 1]++;
        }

        int judge = -1;
        for (int i = 0; i < n; i++) {
            if (!canNotBeJudge[i] && trustCount[i] == n - 1) {
                judge = i + 1;
                break;
            }
        }

        return judge;
    }
}