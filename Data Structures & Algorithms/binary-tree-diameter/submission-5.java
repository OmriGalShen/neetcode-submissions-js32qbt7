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
    private static class Result {
        int maxDiameter = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Result result = new Result();
        dfs(root, result);
        return result.maxDiameter;
    }

    private int dfs(TreeNode node, Result result) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, result);
        int right = dfs(node.right, result);
        result.maxDiameter = Math.max(result.maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
}
