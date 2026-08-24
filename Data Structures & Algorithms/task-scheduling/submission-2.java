class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }

        int maxFreq = Arrays.stream(count).max().getAsInt();
        int maxFreqCount = (int) Arrays.stream(count).filter(a -> a == maxFreq).count();        
        int maxIterations = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(maxIterations, tasks.length);
    }
}
