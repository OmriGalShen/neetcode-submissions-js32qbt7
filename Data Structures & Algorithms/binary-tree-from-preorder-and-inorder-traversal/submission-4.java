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
    // space: O(N)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return dfs(preorder, inorder, valToIndex, 0, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, Map<Integer, Integer> valToIndex,
        int preInd, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preInd];
        int rootIndex = valToIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        TreeNode leftNode = dfs(preorder, inorder, valToIndex, preInd + 1, left, rootIndex - 1);
        TreeNode rightNode = dfs(preorder, inorder, valToIndex, preInd + 1 + (rootIndex-left), rootIndex + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
