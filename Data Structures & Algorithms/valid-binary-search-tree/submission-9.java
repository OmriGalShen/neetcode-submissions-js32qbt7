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
    // time: O(N)
    // space: O(1)
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean dfs(TreeNode node, int leftBound, int rightBound) {
        if (node == null) {
            return true;
        }
        if (node.val >= leftBound) {
            return false;
        }
        if (node.val <= rightBound) {
            return false;
        }
        return dfs(node.left, node.val, rightBound) && dfs(node.right, leftBound, node.val);
    }
}
