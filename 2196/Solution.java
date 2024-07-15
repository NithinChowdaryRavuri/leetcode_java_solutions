import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeftChild = description[2];

            if (!nodeMap.containsKey(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }

            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new TreeNode(child));
            }

            if (isLeftChild == 1) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }

            visited.add(child);
        }

        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!visited.contains(entry.getKey()))
                return entry.getValue();
        }

        return null;
    }
}