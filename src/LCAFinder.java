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

    //O(t) where t is the size of the subtree for the first common ancestor
    //O(n) is the worst case, where n is all nodes in the tree
    public BTNode findUsingSiblingSubtree(BTNode n1, BTNode n2) {
       if (covers(n1, n2)) {
           return n1;
       } else if (covers(n2, n1)) {
          return n2;
       }

       BTNode current = n1;

       while (current != null) {
           BTNode sibling = findSibling(current);

           if (covers(sibling, n2)) {
               return sibling.parent;
           }

           current = current.parent;
       }

       return null;
    }

    private BTNode findSibling(BTNode n1) {
       BTNode parent = n1.parent;

       if (parent.left.value == n1.value) {
           return parent.right;
       } else {
          return parent.left;
       }
    }

    private boolean covers(BTNode n1, BTNode n2) {
        if (n1 == null) {
           return false;
        }

        if (n1.value == n2.value) {
           return true;
        }

        return covers(n1.left, n2) || covers(n1.right, n2);
    }
}
