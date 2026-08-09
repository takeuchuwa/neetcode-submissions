class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        int res = 0;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            long square = (long) middle * middle;
            if (square == x) {
                return middle;
            } else if (square > x) {
                r = middle - 1;
            } else {
                res = middle;
                l = middle + 1;
            }
        }

        return res;
    }
}