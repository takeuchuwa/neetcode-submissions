class KthLargest {

    private List<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>(k + 1);
        this.nums.add(0);
        for (int i = 0; i < nums.length; i++) {
            addLast(nums[i]);
        }
        
    }
    
    public int add(int val) {
        addLast(val);
        return getKthMax();
    }

    private void addLast(int val) {
        if (k + 1 != nums.size()) {
            nums.add(val);
            int i = nums.size() - 1;
            while (i != 1 && val < nums.get(i / 2)) {
                nums.set(i, nums.get(i / 2));
                nums.set(i / 2, val);
                i = i / 2;
            }
        } else if (val > nums.get(1)) {
            int i = 1;
            nums.set(i, val);
            while (2 * i  < nums.size()) {
                int leftChildIndex = 2 * i;
                int rightChildIndex = leftChildIndex + 1;
                if (rightChildIndex < nums.size() && 
                        nums.get(leftChildIndex) > nums.get(rightChildIndex) &&
                        val > nums.get(rightChildIndex)) {
                    nums.set(i, nums.get(rightChildIndex));
                    nums.set(rightChildIndex, val);
                    i = rightChildIndex;
                        
                } else if (val > nums.get(leftChildIndex)) {
                    nums.set(i, nums.get(leftChildIndex));
                    nums.set(leftChildIndex, val);
                    i = leftChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    private int getKthMax() {
        return nums.get(1);
    }
}
