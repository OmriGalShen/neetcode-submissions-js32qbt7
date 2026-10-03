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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int currMax) {
        if (root == null) {
            return 0;
        }
        int newMax = Math.max(root.val, currMax);
        int childrenCount = goodNodes(root.left, newMax) + goodNodes(root.right, newMax);
        if (root.val >= currMax) {
            return 1 + childrenCount;
        } else {
            return childrenCount;
        }
    }
}
