class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
    
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            
            graph[prereq].add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            finishedCourses++;
            
            for (int nextCourse : graph[current]) {
                if (--inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return finishedCourses == numCourses;
    }
        
}
