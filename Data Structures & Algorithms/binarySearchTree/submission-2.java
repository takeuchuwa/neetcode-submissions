class TreeMap {

    private TreeNode root;

    public TreeMap() {
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private TreeNode insert(TreeNode root, int key, int val) {
        if (root == null) {
            root = new TreeNode();
            root.key = key;
            root.val = val;
            return root;
        }

        if (root.key > key) {
            root.left = insert(root.left, key, val);
        } else if (root.key < key) {
            root.right = insert(root.right, key, val);
        } else {
            root.val = val;
        }

        return root;
    }

    public int get(int key) {
        return get(root, key);
    }

    private int get(TreeNode root, int key) {
        if (root == null) return -1;

        if (root.key > key) {
            return get(root.left, key);
        } else if (root.key < key) {
            return get(root.right, key);
        } else {
            return root.val;
        }
    }

    public int getMin() {
        if (root == null) return -1;

        return getMin(root).val;
    }

    private TreeNode getMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public int getMax() {
        if (root == null) return -1;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        return cur.val;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode root, int key) {
        if (root == null)
            return root;
        
        if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode min = getMin(root.right);
                root.right = remove(root.right, min.key);
                root.key = min.key;
                root.val = min.val;
            }
        }

        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> inorderKeys = new ArrayList<>();
        getInorderKeys(root, inorderKeys);
        return inorderKeys;
    }

    private void getInorderKeys(TreeNode root, List<Integer> output) {
        if (root == null)
            return;

        getInorderKeys(root.left, output);
        output.add(root.key);
        getInorderKeys(root.right, output);
    }

    class TreeNode {
        int key;
        int val;
        TreeNode left;
        TreeNode right;
    }
}
