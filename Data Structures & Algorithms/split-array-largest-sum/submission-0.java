class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int l = -1;
        int r = 0;
        for (int num: nums) {
            l = Math.max(l, num);
            r += num;
        }

        int res = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(mid, k, n, prefix)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int largest, int k, int n, int[] prefix) {
        int subarrays = 0, i = 0;
        while (i < n) {
            int l = i, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] - prefix[i] <= largest) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            subarrays++;
            i = r;
            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }
}