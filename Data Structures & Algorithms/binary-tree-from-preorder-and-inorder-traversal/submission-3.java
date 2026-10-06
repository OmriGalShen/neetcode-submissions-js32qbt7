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
    private Map<Integer, Integer> inorderValToInd;
    private int preInd;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preInd = 0;
        this.inorderValToInd = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValToInd.put(inorder[i], i);
        }
        this.preorder = preorder;
        return buildTree(0, inorder.length - 1);
    }

    public TreeNode buildTree(int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        int rootVal = preorder[preInd];
        preInd++;
        TreeNode node = new TreeNode(rootVal);
        int inorderIndex = inorderValToInd.get(rootVal);
        node.left = buildTree(inorderLeft, inorderIndex - 1);
        node.right = buildTree(inorderIndex + 1, inorderRight);
        return node;
    }
}