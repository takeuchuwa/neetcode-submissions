class SegmentTree {

    private SegmentNode root;

    public SegmentTree(int[] nums) {
        root = init(nums, 0, nums.length - 1);
    }

    private SegmentNode init(int[] nums, int L, int R) {
        if (L == R) {
            return new SegmentNode(nums[L], L, R);
        }

        int M = L + (R - L) / 2;
        SegmentNode root = new SegmentNode(0, L, R);
        root.left = init(nums, L, M);
        root.right = init(nums, M + 1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int index, int val) {
        update(index, val, root);
    }

    private void update(int index, int val, SegmentNode root) {
        if (root.L == root.R) {
            root.sum = val;
            return;
        }

        int M = root.L + (root.R - root.L) / 2;
        if (index > M) {
            update(index, val, root.right);
        } else {
            update(index, val, root.left);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int L, int R) {
        return query(L, R, root);
    }

    private int query(int L, int R, SegmentNode root) {
        if (root.L == L && root.R == R) {
            return root.sum;
        }

        int M = root.L + (root.R - root.L) / 2;
        if (L > M) {
            return query(L, R, root.right);
        } else if (R <= M) {
            return query(L, R, root.left);
        } else {
            return query(L, M, root.left) + query(M + 1, R, root.right);
        }
    }

    class SegmentNode {
        int sum;
        SegmentNode left;
        SegmentNode right;
        int L;
        int R;

        SegmentNode(int sum, int L, int R) {
            this.sum = sum;
            this.L = L;
            this.R = R;
        }
    }
}
