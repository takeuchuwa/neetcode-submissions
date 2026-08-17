class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Deque<Integer>> stacks;
    int maxCnt;
    public FreqStack() {
        freqMap = new HashMap<>();
        stacks = new HashMap<>();
    }
    
    public void push(int val) {
        int valCnt = freqMap.merge(val, 1, Integer::sum);
        if (valCnt > maxCnt) {
            maxCnt = valCnt;
            stacks.putIfAbsent(valCnt, new ArrayDeque<>());
        }
        stacks.get(valCnt).push(val);
    }
    
    public int pop() {
        int res = stacks.get(maxCnt).pop();
        freqMap.merge(res, -1, Integer::sum);
        if (stacks.get(maxCnt).isEmpty()) {
            maxCnt--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */