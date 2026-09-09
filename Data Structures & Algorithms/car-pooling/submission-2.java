class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pickupHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> dropoffHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] trip : trips) {
            pickupHeap.offer(new int[] {trip[0], trip[1]});
            dropoffHeap.offer(new int[] {trip[0], trip[2]});
        }

        int currCapacity = 0;
        while (!dropoffHeap.isEmpty()) {
            int currPoint = !pickupHeap.isEmpty() && pickupHeap.peek()[1] < dropoffHeap.peek()[1]
                ? pickupHeap.peek()[1]
                : dropoffHeap.peek()[1];
            while (!dropoffHeap.isEmpty() && dropoffHeap.peek()[1] == currPoint) {
                currCapacity -= dropoffHeap.poll()[0];
            }

            while (!pickupHeap.isEmpty() && pickupHeap.peek()[1] == currPoint) {
                currCapacity += pickupHeap.poll()[0];
            }

            if (currCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}