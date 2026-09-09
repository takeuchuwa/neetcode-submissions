class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int[] trip : trips) {
            heap.offer(new int[] {trip[1], trip[0]});
            heap.offer(new int[] {trip[2], -trip[0]});
        }

        int currCapacity = 0;
        while (!heap.isEmpty()) {
            currCapacity += heap.poll()[1];
            if (currCapacity > capacity) return false;
        }
        return true;
    }
}