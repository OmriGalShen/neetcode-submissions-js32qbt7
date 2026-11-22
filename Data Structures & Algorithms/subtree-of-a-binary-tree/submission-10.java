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
    // time: O(N+M)
    // space: O(N+M)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSb = new StringBuilder();
        serialize(root, rootSb);
        String rootStr = rootSb.toString();

        StringBuilder subSb = new StringBuilder();
        serialize(subRoot, subSb);
        String subStr = subSb.toString();

        return rootStr.contains(subStr);
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N");
            return;
        }
        sb.append(",").append(node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}
