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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfsSerialize(root, result);
        return String.join(",", result);
    }

    private void dfsSerialize(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("N");
            return;
        }
        result.add(String.valueOf(node.val));
        dfsSerialize(node.left, result);
        dfsSerialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrings = data.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for (String nodeStr : nodeStrings) {
            queue.offer(nodeStr);
        }
        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String nodeStr = queue.poll();
        TreeNode node;
        if (nodeStr.equals("N")) {
            return null;
        }

        node = new TreeNode(Integer.parseInt(nodeStr));
        node.left = dfsDeserialize(queue);
        node.right = dfsDeserialize(queue);
        return node;
    }
}
