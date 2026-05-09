class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length, k);
        int[][] kClosest = new int[k][2];
        for (int i = 0; i < k; i++) {
            kClosest[i] = points[i];
        }

        return kClosest;
    }

    public void quickSort(int[][] points, int start, int end, int k) {
        if (end - start <= k) {
            return;
        }

        int[] pivotXY = points[end - 1];
        double pivot = Math.sqrt(Math.pow(pivotXY[0], 2) + Math.pow(pivotXY[1], 2));
        int pointer = 0;
        for (int i = 0; i < end; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            if (distance < pivot) {
                int[] temp = points[pointer];
                points[pointer] = points[i];
                points[i] = temp;
                pointer++;
            }
        }

        points[end - 1] = points[pointer];
        points[pointer] = pivotXY;

        
        int countOfShortetsDistanceToTheLeft = pointer - start + 1;
        if (countOfShortetsDistanceToTheLeft > k) {
            quickSort(points, start, pointer, k);
        } else {
            quickSort(points, pointer + 1, end, k - countOfShortetsDistanceToTheLeft);
        }
        
    }
}
