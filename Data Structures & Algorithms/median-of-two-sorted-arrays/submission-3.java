class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] lower = nums1;
        int[] greater = nums2;
        if (nums1.length > nums2.length) {
            lower = nums2;
            greater = nums1;
        }

        int sum = nums1.length + nums2.length;
        int half = (sum + 1) / 2;

        int low = 0;
        int high = lower.length;

        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = half - i;

            int lowerLeft   = i > 0 ? lower[i - 1] : Integer.MIN_VALUE;
            int lowerRight  = i < lower.length ? lower[i] : Integer.MAX_VALUE;
            int greaterLeft = j > 0 ? greater[j - 1] : Integer.MIN_VALUE;
            int greaterRight= j < greater.length  ? greater[j] : Integer.MAX_VALUE;

            if (greaterLeft <= lowerRight && lowerLeft <= greaterRight) {
                int maxLeft = Math.max(greaterLeft, lowerLeft);
                if (sum % 2 == 1) {
                    return maxLeft;
                }
                return (maxLeft + (double) Math.min(greaterRight, lowerRight)) / 2.;
            } else if (lowerLeft > greaterRight) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return -1;
    }
}