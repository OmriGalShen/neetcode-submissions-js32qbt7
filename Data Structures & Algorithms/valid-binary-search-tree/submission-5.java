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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int currentMin, int currentMax) {
        if (root == null) {
            return true;
        }
        if (root.val <= currentMin || root.val >= currentMax) {
            return false;
        }
        return isValidBST(root.left, currentMin, root.val) && isValidBST(root.right, root.val, currentMax);
    }
}

