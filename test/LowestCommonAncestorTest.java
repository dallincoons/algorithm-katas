import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorTest {
    @Test
    public void getLowestCommonAncestor1() {
        Graph graph = new Graph();

        BTNode root = new BTNode<>('A');
        root.left = new BTNode<>('B');
        root.right = new BTNode<>('E');
        root.left.left = new BTNode<>('C');
        root.left.right = new BTNode<>('D');
        root.left.left.left = new BTNode<>('H');
        root.left.left.right = new BTNode<>('I');
        root.left.right.left = new BTNode<>('J');
        root.left.right.right = new BTNode<>('K');

        root.right = new BTNode<>('E');
        root.right.left = new BTNode<>('F');
        root.right.right = new BTNode<>('G');

        LCAFinder finder = new LCAFinder(root);

        assertEquals(new BTNode<>('B'), finder.find(root.left.left.left, root.left.right.right));
        assertEquals(new BTNode<>('D'), finder.find(root.left.right.left, root.left.right.right));
        assertEquals(new BTNode<>('A'), finder.find(root.left.left.left, root.right.right));
        assertEquals(new BTNode<>('B'), finder.find(root.left.right, root.left.left));
        assertEquals(new BTNode<>('E'), finder.find(root.right, root.right.right));
    }
}
