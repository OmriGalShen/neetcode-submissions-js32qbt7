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
        if (root == null) {
            return 0;
        }
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int currMax) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= currMax) {
            currMax = node.val;
            count++;
        }
        return count + dfs(node.left, currMax) + dfs(node.right, currMax);
    }
}
