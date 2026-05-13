class KthLargest {

    private int[] heap;
    private int size;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            addLast(nums[i]);
        }
        
    }
    
    public int add(int val) {
        addLast(val);
        return getKthMax();
    }

    private void addLast(int val) {
        if (k != size) {
            heap[++size] = val;
            int i = size;
            while (i > 1 && val < heap[i / 2]) {
                int parent = i / 2;
                heap[i] = heap[parent];
                i = parent;
            }
            heap[i] = val;
        } else if (val > heap[1]) {
            int i = 1;
            heap[i] = val;
            while (2 * i  <= size) {
                int leftChildIndex = 2 * i;
                int rightChildIndex = leftChildIndex + 1;
                if (rightChildIndex <= size && 
                        heap[leftChildIndex] > heap[rightChildIndex] &&
                        val > heap[rightChildIndex]) {
                    heap[i] = heap[rightChildIndex];
                    heap[rightChildIndex] = val;
                    i = rightChildIndex;
                        
                } else if (val > heap[leftChildIndex]) {
                    heap[i] = heap[leftChildIndex];
                    heap[leftChildIndex] = val;
                    i = leftChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    private int getKthMax() {
        return heap[1];
    }
}
