class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int hours = 0;
        int left = 1;
        int right = max;
        int minK = max;
        while (left <= right) {
            hours = 0;
            int middle = left + (right - left) / 2;
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / middle;
                if (piles[i] % middle != 0) {
                    hours++;
                }
            }

            if (hours > h) {
                left = middle + 1;
            } else if (hours <= h) {
                minK = middle;
                right = middle - 1;
            }

        }

        return minK;
    }
}
