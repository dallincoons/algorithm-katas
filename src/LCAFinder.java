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

    public BTNode findUsingLinkIntersection(BTNode root, BTNode n1, BTNode n2) {
        BTNode bigger;
        BTNode smaller;

        int n1Depth = getNodeDepth(root, n1);
        int n2Depth = getNodeDepth(root, n2);

        if (n1Depth >= n2Depth) {
            bigger = n1;
            smaller = n2;
        } else {
            bigger = n2;
            smaller = n1;
        }

        int difference = Math.abs(n1Depth - n2Depth);

        for(int i = 0; i < difference; i++) {
           bigger = bigger.parent;
        }

        for(int i = 0; i < Math.min(n1Depth, n2Depth); i++) {
            if (bigger.equals(smaller)) {
                return smaller;
            }

            bigger = bigger.parent;
            smaller = smaller.parent;
        }

        return new BTNode<>('Z');
    }

    private int getNodeDepth(BTNode root, BTNode node) {
        if (node.equals(root)) {
           return 0;
        }

        int depth = 1;
        while (!node.parent.equals(root)) {
            node = node.parent;
            depth++;
        }

        return depth;
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

    //Useful for when we don't have links to parents.
    //This isn't the most optimal solution, but it's fairly straightforward
    public BTNode findLCAWithTreeDissection(BTNode root, BTNode n1, BTNode n2) {
        if (!covers(root, n1) || !covers(root, n2)) {
            return null;
        }

        return getLCAFromDissection(root, n1, n2);
    }

    public BTNode getLCAFromDissection(BTNode root, BTNode n1, BTNode n2) {
        if (root == null || root == n1 || root == n2) {
            return root;
        }

        boolean n1FoundLeft = covers(root.left, n1);
        boolean n2FoundLeft = covers(root.left, n2);

        if (n1FoundLeft ^ n2FoundLeft) {
            return root;
        }

        if (n1FoundLeft && n2FoundLeft) {
            return findLCAWithTreeDissection(root.left, n1, n2);
        } else {
            return findLCAWithTreeDissection(root.right, n1, n2);
        }
    }

    public BTNode findLCAUsingBubbleUp(BTNode root, BTNode n1, BTNode n2) {
        if (!covers(root, n1) || !covers(root, n2)) {
            return null;
        }

       return bubbleUp(root, n1, n2);
    }

    private BTNode bubbleUp(BTNode root, BTNode n1, BTNode n2) {
        if (root == null) {
            return null;
        }

        if (root.value == n1.value && root.value == n2.value) {
            return root;
        }

        BTNode leftTree = bubbleUp(root.left, n1, n2);
        if (leftTree != null && leftTree.value != n1.value && leftTree.value != n2.value) {
            return leftTree;
        }

        BTNode rightTree = bubbleUp(root.right, n1, n2);
        if (rightTree != null && rightTree.value != n1.value && rightTree.value != n2.value) {
            return rightTree;
        }

        if (leftTree != null && rightTree != null) {
            return root;
        }

        if (root.value == n1.value || root.value == n2.value) {
            return root;
        }

        return leftTree == null ? rightTree : leftTree;
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

    public BTNode findLCAUsingObjectBubbleUp(BTNode root, BTNode n1, BTNode n2) {
        Result result = doLCAUsingObjectBubbleUp(root, n1, n2);
        if (result.isAncestor) {
           return result.node;
        }

        return null;
    }

    public Result doLCAUsingObjectBubbleUp(BTNode root, BTNode n1, BTNode n2) {
        if (root == null) {
            return new Result(null, false);
        }

        if (root.value == n1.value && root.value == n2.value) {
            return new Result(root, true);
        }

        Result leftTree = doLCAUsingObjectBubbleUp(root.left, n1, n2);
        if (leftTree.isAncestor) {
            return leftTree;
        }

        Result rightTree = doLCAUsingObjectBubbleUp(root.right, n1, n2);
        if (rightTree.isAncestor) {
            return rightTree;
        }

        if (leftTree.node != null && rightTree.node != null) {
            return new Result(root, true);
        }

        //if we're currently at p or q, and we also found one of those nodes in a subtree
        //then this is truly an ancestor and the flag should be true
        if (root.value == n1.value || root.value == n2.value) {
            boolean isAncestor = leftTree.node != null || rightTree.node != null;

            return new Result(root, isAncestor);
        }

        return new Result(leftTree.node == null ? rightTree.node : leftTree.node, false);
    }

    private class Result {
        public BTNode node;
        public boolean isAncestor;
        public Result(BTNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }
}
