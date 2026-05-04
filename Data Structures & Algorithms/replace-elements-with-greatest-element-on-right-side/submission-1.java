class Solution {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }

        return ans;
    }
}