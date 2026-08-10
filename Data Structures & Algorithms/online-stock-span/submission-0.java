class StockSpanner {

    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int[] priceAndSpan = new int[]{price, 1};
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            priceAndSpan[1] += stack.pop()[1];
        }

        stack.push(priceAndSpan);

        return stack.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */