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
    int rootPointer = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return buildTree(preorder, inorder, 0, n);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start >= end) {
            return null;
        }
        
        int rootVal = preorder[rootPointer++];
        TreeNode root = new TreeNode(rootVal);
        if (end - start <= 1) {
            return root;
        }
        int inorderPointerRoot = -1;
        for (int i = start; i < end; i++) {
            if (inorder[i] == rootVal) {
                inorderPointerRoot = i;
                break;
            }
        }

        root.left = buildTree(preorder, inorder, start, inorderPointerRoot);
        root.right = buildTree(preorder, inorder, inorderPointerRoot + 1, end);

        return root;
    }
}
