class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if ((j & 1) == 1) {
                    count[i]++;
                }
                j >>= 1;
            }
        }

        return count;
    }
}
