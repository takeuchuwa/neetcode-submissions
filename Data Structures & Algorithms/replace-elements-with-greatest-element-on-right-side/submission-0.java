class Solution {
    public int[] replaceElements(int[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == maxIndex) {
                maxIndex = i + 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } 
            arr[i] = arr[maxIndex];
        }
        arr[arr.length - 1] = -1;

        return arr;
    }
}