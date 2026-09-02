class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int parent = i / 2;
            int tmp = heap.get(parent);
            heap.set(parent, heap.get(i));
            heap.set(i, tmp);
            i = parent;
        }
    }

    public Integer pop() {
        if (heap.size() > 1) {
            Integer pop = heap.get(1);
            Integer last = heap.remove(heap.size() - 1);
            if (pop != last) {
                heap.set(1, last);
                shiftDown(1);
            }

            return pop;
        }
        
        return -1;
    }

    private void shiftDown(int i) {
        while (2 * i < heap.size()) {
            int left = 2 * i;
            int right = 2 * i + 1;
            if (right < heap.size() && 
                    heap.get(right) < heap.get(left) &&
                    heap.get(i) > heap.get(right)) {
                int tmp = heap.get(right);
                heap.set(right, heap.get(i));
                heap.set(i, tmp);
                i = right;
            } else if (heap.get(i) > heap.get(left)) {
                int tmp = heap.get(left);
                heap.set(left, heap.get(i));
                heap.set(i, tmp);
                i = left;
            } else {
                break;
            }
        }
    }

    public Integer top() {
        if (heap.size() > 1) {
            return heap.get(1);
        }

        return -1;
    }

    public void heapify(List<Integer> nums) {
        if (nums.size() == 0) return;
        heap = nums;
        heap.add(heap.get(0));

        int cur = heap.size() / 2;
        while (cur > 0) {
            int i = cur;
            shiftDown(i);
            cur--;
        }
    }
}
