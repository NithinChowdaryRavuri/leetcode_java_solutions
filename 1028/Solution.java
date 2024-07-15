class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> nodeStack = new Stack<>();
        int currentDepth = 0;
        int currentValue = 0;

        for (int i = 0; i < traversal.length(); i++) {
            if (traversal.charAt(i) == '-') {
                currentDepth++;
            } else {
                currentValue = 10 * currentValue + (traversal.charAt(i) - '0');
            }

            if (i + 1 == traversal.length()
                    || (Character.isDigit(traversal.charAt(i)) && traversal.charAt(i + 1) == '-')) {
                TreeNode newNode = new TreeNode(currentValue);

                while (nodeStack.size() > currentDepth) {
                    nodeStack.pop();
                }

                if (!nodeStack.isEmpty()) {
                    if (nodeStack.peek().left == null) {
                        nodeStack.peek().left = newNode;
                    } else {
                        nodeStack.peek().right = newNode;
                    }
                }

                nodeStack.push(newNode);
                currentDepth = 0;
                currentValue = 0;
            }
        }

        TreeNode result = null;
        while (!nodeStack.isEmpty()) {
            result = nodeStack.peek();
            nodeStack.pop();
        }

        return result;
    }
}