public class BSTSuccessorFinder {
    public Integer findSuccessor(BTNode<Integer> node) {
        if (node.right != null) {
           return findLowestValueInTree(node.right).value;
        } else {
            BTNode<Integer> current = node;
            BTNode<Integer> parent = node.parent;

            while (parent != null) {
                if (parent.left != null && parent.left.value == current.value) {
                    current = current.parent;
                    break;
                }
                current = current.parent;
                parent = current.parent;
            }

            return current.value;
        }
    }

    private BTNode<Integer> findLowestValueInTree(BTNode root) {
        if (root.left == null) {
            return root;
        }

        return findLowestValueInTree(root.left);
    }
}
