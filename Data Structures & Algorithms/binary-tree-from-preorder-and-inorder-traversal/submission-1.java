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
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n, map);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {
        if (start >= end) {
            return null;
        }
        
        int rootVal = preorder[rootPointer++];
        TreeNode root = new TreeNode(rootVal);
        if (end - start <= 1) {
            return root;
        }
        int inorderPointerRoot = map.get(rootVal);

        root.left = buildTree(preorder, inorder, start, inorderPointerRoot, map);
        root.right = buildTree(preorder, inorder, inorderPointerRoot + 1, end, map);

        return root;
    }
}
