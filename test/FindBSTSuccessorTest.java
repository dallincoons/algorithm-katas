import org.junit.Test;

import static org.junit.Assert.*;

public class FindBSTSuccessorTest {
    @Test
    public void findSuccessorInBalancedTree() {
        BSTMaker maker = new BSTMaker();

        BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16,25,31,44,68,91,101});

        BSTSuccessorFinder finder = new BSTSuccessorFinder();

        assertEquals(Integer.valueOf(16), finder.findSuccessor(node));
        assertEquals(Integer.valueOf(68), finder.findSuccessor(node.right));
        assertEquals(Integer.valueOf(101), finder.findSuccessor(node.right.right));
        assertNull(finder.findSuccessor(node.right.right.right));
    }

    @Test
    public void findSuccessorInUnbalancedTree() {
        BTNode root = new BTNode<>(50);
        root.left = new BTNode<>(25);
        root.right = new BTNode<>(75);

        root.right.left = new BTNode<>(60);

        root.left.left = new BTNode<>(10);
        root.left.right = new BTNode<>(30);

        root.left.right.right = new BTNode<>(35);

        root.left.left.left = new BTNode<>(5);

        root.left.right.right.parent = root.left.right;
        root.left.right.parent = root.left;
        root.left.parent = root;
        root.right.left.parent = root.right;

        BSTSuccessorFinder finder = new BSTSuccessorFinder();

        assertEquals(Integer.valueOf(50), finder.findSuccessor(root.left.right.right));
        assertEquals(Integer.valueOf(35), finder.findSuccessor(root.left.right));
        assertEquals(Integer.valueOf(75), finder.findSuccessor(root.right.left));
    }
}
