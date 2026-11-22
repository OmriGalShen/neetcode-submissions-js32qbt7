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
        int val = -1;
        int count = 0;
    }
    public int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        dfs(root, k, result);
        return result.val;
    }

    private void dfs(TreeNode node, int k, Result result) {
        if (node == null || result.count > k) {
            return;
        }
        dfs(node.left, k, result);
        result.count++;
        if (result.count == k) {
            result.val = node.val;
        }
        dfs(node.right, k, result);
    }
}
