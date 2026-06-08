class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        int p1 = 0;
        int p2 = n - 1;
        while (p1 < p2) {
            int calc = 0;
            if (heights[p1] > heights[p2]) {
                calc = (p2 - p1) * heights[p2];
                p2--;
            } else {
                calc = (p2 - p1) * heights[p1];
                p1++;
            }
            max = Math.max(max, calc);
        }

        return max;
    }
}
