class MinStack {

    private int[] stack;
    private Map<Integer, Integer> minimum;
    private int pointer;

    public MinStack() {
        stack = new int[10];
        minimum = new HashMap<>();
        pointer = -1;
    }
    
    public void push(int val) {
        int n = stack.length;
        Integer minVal = minimum.getOrDefault(pointer, val);
        if (++pointer == n) {
            int[] newStack = new int[n * 2];
            for (int i = 0; i < n; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }

        stack[pointer] = val;
        
        minimum.put(pointer, Math.min(val, minVal));
    }
    
    public void pop() {
        minimum.remove(pointer--);
    }
    
    public int top() {
        return stack[pointer];
    }
    
    public int getMin() {
        return minimum.get(pointer);
    }
}
