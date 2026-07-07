class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            adjList.get(time[0]).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int reachCount = 0;
        boolean[] reach = new boolean[n + 1];
        min.offer(new int[] {k, 0});

        while (!min.isEmpty()) {
            int[] node = min.poll();
            int edge = node[0];
            int weight = node[1];
            if (!reach[edge]) {
                reach[edge] = true;
                reachCount++;
            } else {
                continue;
            }

            if (reachCount == n) {
                return weight;
            }
            for (int[] neighbour : adjList.get(edge)) {
                if (!reach[neighbour[0]]) {
                    min.offer(new int[] {neighbour[0], weight + neighbour[1]});
                }
            }
        }

        return -1;
    }
}
