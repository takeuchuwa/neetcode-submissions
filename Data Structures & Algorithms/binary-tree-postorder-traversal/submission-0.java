/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>(); 
        Deque<Boolean> visited = new ArrayDeque<>();

        stack.push(root);
        visited.push(Boolean.FALSE);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            Boolean visit = visited.pop();
            if (curr != null) {
                if (Boolean.TRUE.equals(visit)) {
                    res.add(curr.val);
                } else {
                    stack.push(curr);
                    visited.push(Boolean.TRUE);
                    stack.push(curr.right);
                    visited.push(Boolean.FALSE);
                    stack.push(curr.left);
                    visited.push(Boolean.FALSE);
                }
            }
        }

        return res;
    }
}