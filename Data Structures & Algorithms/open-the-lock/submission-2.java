class Solution {
    public int openLock(String[] deadends, String target) {
        int[][] neighbours = new int[][] {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {-1, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 0, -1}
        };
        Queue<char[]> queue = new ArrayDeque<>();
        Set<String> deadend = new HashSet<>();
        for (String s : deadends) {
            deadend.add(s);
        }
        char[] root = new char[]{'0','0','0','0'};
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] curr = queue.poll();
                String currS = new String(curr);
                if (deadend.contains(currS)) {
                    continue;
                } else {
                    deadend.add(currS);
                }
                if (target.equals(currS)) {
                    return count;
                }
                System.out.println(curr[0] + "" + curr[1] + "" + curr[2] + "" + curr[3]);
                for (int[] neighbour : neighbours) {
                    char[] q = new char[4];
                    q[0] = (char) (((curr[0] - '0' + neighbour[0] + 10) % 10) + '0');
                    q[1] = (char) (((curr[1] - '0' + neighbour[1] + 10) % 10) + '0');
                    q[2] = (char) (((curr[2] - '0' + neighbour[2] + 10) % 10) + '0');
                    q[3] = (char) (((curr[3] - '0' + neighbour[3] + 10) % 10) + '0');
                    String qS = new String(q);
                    if (!deadend.contains(qS)) {
                        queue.offer(q);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}