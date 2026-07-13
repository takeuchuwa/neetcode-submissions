class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 1; i < n; i++) {
            minHeap.offer(new int[]{i,
                Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1])
            });
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            if (visited[node[0]]) {
                continue;
            }

            res += node[1];
            visited[node[0]] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && node[0] != i) {
                    minHeap.offer(new int[]{i,
                        Math.abs(points[node[0]][0] - points[i][0]) + Math.abs(points[node[0]][1] - points[i][1])
                    });
                }
            }
        }

        return res;

    }
}
