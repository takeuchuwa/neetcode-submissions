class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer finishedCourse = queue.poll();
                finishedCourses++;
                for (Integer prerequisite : graph.get(finishedCourse)) {
                    if (--inDegree[prerequisite] == 0) {
                        queue.offer(prerequisite);
                    }
                }
            }
        }

        return finishedCourses == numCourses;
    }
        
}
