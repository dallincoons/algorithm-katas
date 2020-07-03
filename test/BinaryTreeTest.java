import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void makeBinarySearchTreeFromSortedArray() {
         BSTMaker maker = new BSTMaker();

         BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16});

         assertEquals(9, node.value);

         assertEquals(3, node.left.value);
         assertEquals(14, node.right.value);

        assertEquals(1, node.left.left.value);
        assertEquals(5, node.left.right.value);
        assertEquals(13, node.right.left.value);
        assertEquals(15, node.right.right.value);

        assertNull(node.left.left.left);
        assertNull(node.left.left.right);
        assertNull(node.right.left.left);
        assertNull(node.right.left.right);

        assertNull(node.left.right.left);
        assertNull(node.right.right.left);
        assertEquals(8, node.left.right.right.value);
        assertEquals(16, node.right.right.right.value);
    }

    @Test
    public void getDepthLinkedLists() {
        BSTMaker maker = new BSTMaker();

        BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16});

        TreeDepthFinder finder = new TreeDepthFinder();

        HashMap<Integer, ArrayList<BTNode>> depths = finder.findDepths(node);

        assertEquals(9, depths.get(0).get(0).value);

        assertEquals(2, depths.get(1).size());
        assertEquals(3, depths.get(1).get(0).value);
        assertEquals(14, depths.get(1).get(1).value);

        assertEquals(4, depths.get(2).size());
        assertEquals(1, depths.get(2).get(0).value);
        assertEquals(5, depths.get(2).get(1).value);
        assertEquals(13, depths.get(2).get(2).value);
        assertEquals(15, depths.get(2).get(3).value);

        assertEquals(2, depths.get(3).size());
        assertEquals(8, depths.get(3).get(0).value);
        assertEquals(16, depths.get(3).get(1).value);
    }

    @Test
    public void checkThatTreeIsBalanced() {
        BSTMaker maker = new BSTMaker();
        BalancedTreeChecker checker = new BalancedTreeChecker();

        BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16});

        assertTrue(checker.isBalanced(node));
    }

    @Test
    public void checkThatTreeIsNotBalanced()
    {
        BalancedTreeChecker checker = new BalancedTreeChecker();

        BTNode root = new BTNode(50);
        root.left = new BTNode(25);
        root.right = new BTNode(25);

        root.left.left = new BTNode(20);
        root.left.right = new BTNode(35);

        root.left.left.left = new BTNode(10);
        root.left.left.right = new BTNode(22);

        root.left.right.left = new BTNode(30);
        root.left.right.left = new BTNode(40);

        root.right.right = new BTNode(75);
        root.right.right = new BTNode(90);
        root.right.right.left = new BTNode(80);
        root.right.right.right = new BTNode(95);

        assertFalse(checker.isBalanced(root));
    }

    @Test
    public void checkValidBinarySearchTree() {
        BSTMaker maker = new BSTMaker();
        BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16});

        BSTValidator validator = new BSTValidator();

        assertTrue(validator.isValidBST(node));
    }

    @Test
    public void checkInvalidBinarySearchTree() {
        BSTMaker maker = new BSTMaker();
        BTNode node = maker.makeBST(new int[]{3,1,5,8,9,13,14,15,16});

        BSTValidator validator = new BSTValidator();

        assertFalse(validator.isValidBST(node));
    }

    @Test
    public void checkValidBinarySearchTreeMinMax() {
        BSTMaker maker = new BSTMaker();
        BTNode node = maker.makeBST(new int[]{1,3,5,8,9,13,14,15,16});

        BSTValidator validator = new BSTValidator();

        assertTrue(validator.isValidBSTMinMax(node));
    }

    @Test
    public void checkInvalidBinarySearchTreeMinMax() {
        BSTMaker maker = new BSTMaker();
        BTNode node = maker.makeBST(new int[]{3,1,5,8,9,13,14,15,16});

        BSTValidator validator = new BSTValidator();

        assertFalse(validator.isValidBSTMinMax(node));
    }
}
