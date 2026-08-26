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
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter max = new Diameter();
        getMaxDiameter(root, max);
        return max.value;
    }

    private int getMaxDiameter(TreeNode root, Diameter max) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getMaxDiameter(root.left, max);
        int rightHeight = getMaxDiameter(root.right, max);
        max.value = Math.max(max.value, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class Diameter  {
        private int value;
    }
}
