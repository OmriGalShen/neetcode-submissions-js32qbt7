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
    int k;
    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 0){
            return -1;
        }
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        k --;
        if(k == 0){
            res = node.val;
        }
        dfs(node.right);
    }
}
