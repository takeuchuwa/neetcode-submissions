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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = isBalanced(root.left, 1);
        int right = isBalanced(root.right, 1);

        return left > 0 && right > 0 ? Math.abs(left - right) <= 1 : false;
    }

    public int isBalanced(TreeNode root, int height) {
        if (root == null) {
            return height;
        }

        height++;
        int left = isBalanced(root.left, height);
        int right = isBalanced(root.right, height);

        if (Math.abs(left - right) <= 1) {
            return left > right ? left : right;
        } else {
            return -1;
        }
    }
}
