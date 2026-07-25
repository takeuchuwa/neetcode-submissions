class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        return dfsHelper(0, days, costs, cache);
    }

    private int dfsHelper(int i, int[] days, int[] costs, int[] cache ) {
        if (i >= days.length) {
            return 0;
        }

        if (cache[i] != 0) {
            return cache[i];
        }
        
        int val1 = costs[0] + dfsHelper(i + 1, days, costs, cache);
        int j;
        for (j = i; j < days.length && days[j] < days[i] + 7; j++); 
        int val2 = costs[1] + dfsHelper(j, days, costs, cache);
        for (j = i; j < days.length && days[j] < days[i] + 30; j++);
        int val3 = costs[2] + dfsHelper(j, days, costs, cache); 

        cache[i] = Math.min(val1, Math.min(val2, val3));

        return cache[i];
    }
}