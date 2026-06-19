class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large =  new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        if (!large.isEmpty() && small.peek() > large.peek()) {
            Integer lg = small.poll();
            Integer sm = large.poll();
            large.add(lg);
            small.add(sm);
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.;
    }
}
