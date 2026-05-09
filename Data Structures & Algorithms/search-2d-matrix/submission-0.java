class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int indexM = middle / n;
            int indexN = middle % n;
            int compare = matrix[indexM][indexN];
            if (target > compare) {
                left = middle + 1;
            } else if (target < compare) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
