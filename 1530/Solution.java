class Solution {
    int result = 0;

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return result;
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode root, int distance) {
        if (root == null) return new int[] {};
        if (root.left == null && root.right == null) {
            return new int[] {1};
        }

        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);

        for(int lNum: left) {
            if (lNum > distance) continue;
            for(int rNum: right) {
                result += lNum+rNum <= distance ? 1:0;
            }
        }

        int size = left.length + right.length;
        int[] values = new int[size];
        for(int i=0; i<left.length; i++) {
            values[i] = left[i]+1;
        }
        for(int i=0; i<right.length; i++) {
            values[left.length + i] = right[i]+1;
        }

        return values;
    }
}