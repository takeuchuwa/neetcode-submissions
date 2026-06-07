class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 0;
        int n = arr.length;
        int L = 0;
        int R = 0;
        while (R < n - 1) {
            boolean even = R % 2 == 0;
            if (!(!even && arr[R] > arr[R + 1] || even && arr[R] < arr[R + 1])) {
                max = Math.max(max, R - L + 1);
                L = R + 1;
            }
            R++;
        }
        max = Math.max(R - L + 1, max);
        L = 0;
        R = 0;
        while (R < n - 1) {
            boolean even = R % 2 == 0;
            if (!(!even && arr[R] < arr[R + 1] || even && arr[R] > arr[R + 1])) {
                max = Math.max(max, R - L + 1);
                L = R + 1;
            }
            R++;
        }
        

        return Math.max(R - L + 1, max);
    }
}