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
    int index = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;

    }

    public void dfs(TreeNode root, int k) {
        if (index == k) return;
        if (root == null) return ;
        
        dfs(root.left, k);
        index++;
        if (k == index) {
            val = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
