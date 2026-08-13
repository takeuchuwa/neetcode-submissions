class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < x) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        List<Integer> output = new ArrayList<>(k);
        int p1 = low;
        int p2 = low;
        while (p2 - p1 < k) {
            if (p1 == 0) {
                p2++;
                continue;
            } else if (p2 == arr.length) {
                p1--;
                continue;
            }

            int lower = Math.abs(arr[p1 - 1] - x);
            int upper = Math.abs(arr[p2] - x);

            if (lower <= upper) {
                p1--;
            } else {
                p2++;
            }
        }

        for (int i = p1; i < p2; i++) {
            output.add(arr[i]);
        }

        
        return output;
    }
}