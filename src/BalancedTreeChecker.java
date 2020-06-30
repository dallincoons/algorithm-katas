public class BalancedTreeChecker {
    public boolean isBalanced(BTNode root) {
        return getTreeHeight(root) != Integer.MIN_VALUE;
    }

    private int getTreeHeight(BTNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);

        if (leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE) {
           return Integer.MIN_VALUE;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
           return Integer.MIN_VALUE;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
