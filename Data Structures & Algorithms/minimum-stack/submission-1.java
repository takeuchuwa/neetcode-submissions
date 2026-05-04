class MinStack {

    private int[] stack;
    private int[] minStack;
    private int pointer;

    public MinStack() {
        stack = new int[10];
        minStack = new int[10];
        pointer = -1;
    }
    
    public void push(int val) {
        if (++pointer == stack.length) {
            stack = resize(stack);
            minStack = resize(minStack);
        }

        stack[pointer] = val;
        if (pointer == 0) {
            minStack[pointer] = val;
        } else {
            minStack[pointer] = Math.min(val, minStack[pointer - 1]);
        }
    }
    
    private int[] resize(int[] stack) {
        int n = stack.length;
        int[] newStack = new int[n * 2];
        for (int i = 0; i < n; i++) {
            newStack[i] = stack[i];
        }

        return newStack;
    }

    public void pop() {
        pointer--;
    }
    
    public int top() {
        return stack[pointer];
    }
    
    public int getMin() {
        return minStack[pointer];
    }
}
