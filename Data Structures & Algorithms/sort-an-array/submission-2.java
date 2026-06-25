public class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapify(int[] arr, int n, int i) {
        int l = (i << 1) + 1;
        int r = (i << 1) + 2;
        int largestNode = i;

        if (l < n && arr[l] > arr[largestNode]) {
            largestNode = l;
        }

        if (r < n && arr[r] > arr[largestNode]) {
            largestNode = r;
        }

        if (largestNode != i) {
            int temp = arr[i];
            arr[i] = arr[largestNode];
            arr[largestNode] = temp;
            heapify(arr, n, largestNode);
        }
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
}