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

class Codec {
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(",", list);
    }

    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        list.add(Integer.toString(root.val));
        serialize(root.left, list);
        serialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));
        this.index = 0;
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        String nodeVal = list.get(index);
        if (nodeVal.equals("null")) {
            this.index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
        this.index++;
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
