import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[] toDelete = new boolean[1001];
    private List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int value : to_delete) {
            toDelete[value] = true;
        }

        if (returnValidRoot(root) != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode returnValidRoot(TreeNode node) {
        if (node == null)
            return null;

        node.left = returnValidRoot(node.left);
        node.right = returnValidRoot(node.right);

        if (!toDelete[node.val])
            return node;
        if (node.left != null)
            forest.add(node.left);
        if (node.right != null)
            forest.add(node.right);

        return null;
    }
}