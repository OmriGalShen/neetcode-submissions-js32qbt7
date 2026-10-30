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
    private static class Result{
        int res = Integer.MIN_VALUE;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Result res = new Result();
        dfs(root, res);
        return res.res;
    }
    
    private int dfs(TreeNode node, Result res){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        res.res = Math.max(res.res, left + right);
        return 1 + Math.max(left, right);
    }
}
