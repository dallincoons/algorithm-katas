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

    @Test
    public void findLCAUsingLinkIntersection() {
        BTNode root = new BTNode<>('A');

        root.left = new BTNode<>('B');
        root.left.parent = root;

        root.right = new BTNode<>('C');
        root.right.parent = root;

        root.left.left = new BTNode<>('D');
        root.left.left.parent = root.left;

        root.left.left.left = new BTNode<>('E');
        root.left.left.left.parent = root.left.left;

        root.left.left.right = new BTNode<>('F');
        root.left.left.right.parent = root.left.left;

        root.left.right = new BTNode<>('G');
        root.left.right.parent = root.left;

        root.left.right.right = new BTNode<>('H');
        root.left.right.right.parent = root.left.right;

        LCAFinder finder = new LCAFinder(root);

        assertEquals('D', finder.findUsingSiblingSubtree(root.left.left , root.left.left.right).value);
        assertEquals('B', finder.findUsingSiblingSubtree(root.left.left.right, root.left.right.right).value);
        assertEquals('D', finder.findUsingSiblingSubtree(root.left.left.left, root.left.left.right).value);
        assertEquals('A', finder.findUsingSiblingSubtree(root.left.left.left, root.right).value);
    }

    @Test
    public void findLCAUsingSiblingSubtree() {
        BTNode root = new BTNode<>('A');

        root.left = new BTNode<>('B');
        root.left.parent = root;

        root.right = new BTNode<>('C');
        root.right.parent = root;

        root.left.left = new BTNode<>('D');
        root.left.left.parent = root.left;

        root.left.left.left = new BTNode<>('E');
        root.left.left.left.parent = root.left.left;

        root.left.left.right = new BTNode<>('F');
        root.left.left.right.parent = root.left.left;

        root.left.right = new BTNode<>('G');
        root.left.right.parent = root.left;

        root.left.right.right = new BTNode<>('H');
        root.left.right.right.parent = root.left.right;

        LCAFinder finder = new LCAFinder(root);

        assertEquals(new BTNode<>('D'), finder.findUsingSiblingSubtree(root.left.left , root.left.left.right));
        assertEquals(new BTNode<>('B'), finder.findUsingSiblingSubtree(root.left.left.right, root.left.right.right));
        assertEquals(new BTNode<>('D'), finder.findUsingSiblingSubtree(root.left.left.left, root.left.left.right));
        assertEquals(new BTNode<>('A'), finder.findUsingSiblingSubtree(root.left.left.left, root.right));
    }
}
