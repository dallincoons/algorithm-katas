public class LCAFinder {
    private BTNode root;

    LCAFinder(BTNode root) {
        this.root = root;
    }

    public BTNode find(BTNode n1, BTNode n2) {
        return findNode(this.root, n1, n2);
    }

    private BTNode findNode(BTNode root, BTNode n1, BTNode n2) {
        if (root == null) return null;
        if (root.value == n1.value || root.value == n2.value) {
            return root;
        }

        BTNode leftSearchResult = findNode(root.left, n1, n2);
        BTNode rightSearchResult = findNode(root.right, n1, n2);

        if (leftSearchResult != null && rightSearchResult != null) {
            return root;
        }

        if (leftSearchResult != null) {
            return leftSearchResult;
        }

        if (rightSearchResult != null) {
            return rightSearchResult;
        }

        return null;
    }

}
