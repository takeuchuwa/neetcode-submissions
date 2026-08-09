class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for (int weight: weights) {
            max = Math.max(weight, max);
            sum += weight;
        }

        int low = max;
        int high = sum;
        int minWeight = sum;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int currDays = 1;
            int currWeight = 0;
            for (int weight: weights) {
                if (currWeight + weight > middle) {
                    currDays++;
                    currWeight = weight;
                } else {
                    currWeight += weight;
                }

            }
            if (currDays <= days) {
                high = middle - 1;
                minWeight = middle;
            } else {
                low = middle + 1;
            }
        }

        return minWeight;
    }
}