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
}
