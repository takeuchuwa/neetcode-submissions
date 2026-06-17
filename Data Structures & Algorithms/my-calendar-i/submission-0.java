class MyCalendar {
    private TreeNode root;

    public MyCalendar() {
    }

    private boolean insert(TreeNode node, int start, int end) {
        if (start >= node.end) {
            if (node.right == null) {
                node.right = new TreeNode(start, end);
                return true;
            }
            return insert(node.right, start, end);
        } else if (end <= node.start) {
             if (node.left == null) {
                node.left = new TreeNode(start, end);
                return true;
            }
            return insert(node.left, start, end);
        }
        
        return false;
    }
    
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new TreeNode(startTime, endTime);
            return true;
        }

        return insert(root, startTime, endTime);
    }

    class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */