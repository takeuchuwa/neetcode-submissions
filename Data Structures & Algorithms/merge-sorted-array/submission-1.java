class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = n;
        int p2 = 0;

        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int i = 0;
        while (p1 < m+n && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[i] = nums1[p1++];
            } else {
                nums1[i] = nums2[p2++];
            }
            i++;
        }

        while (p1 < m) {
            nums1[i++] = nums1[p1++];
            i++;
            p1++;
        }

        while (p2 < n) {
            nums1[i++] = nums2[p2++];
        }
    }
}