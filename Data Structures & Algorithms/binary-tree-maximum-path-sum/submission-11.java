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
        int val = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        Result res = new Result();
        dfs(root, res);
        return res.val;
    }
    public int dfs(TreeNode root, Result res) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int left = Math.max(0,dfs(root.left, res));
        int right = Math.max(0,dfs(root.right, res));
        res.val = Math.max(res.val, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
