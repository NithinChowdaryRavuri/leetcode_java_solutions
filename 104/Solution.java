/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int result = 0;

    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        result = Math.max(result, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        return;
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return result;
    }
}