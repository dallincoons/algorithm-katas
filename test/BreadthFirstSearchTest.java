import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void FindExistingPathUsingBFS()
    {
        Graph graph = new Graph();

        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(7,6);
        graph.addEdge(3,4);
        graph.addEdge(4,8);
        graph.addEdge(8,9);
        graph.addEdge(10,11);
        graph.addEdge(11,12);
        graph.addEdge(11,13);
        graph.addEdge(13,14);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);

        assertTrue(bfs.hasPath(graph.getVertice(1), graph.getVertice(9)));
        assertTrue(bfs.hasPath(graph.getVertice(7), graph.getVertice(2)));
        assertFalse(bfs.hasPath(graph.getVertice(1), graph.getVertice(14)));
        assertTrue(bfs.hasPath(graph.getVertice(10), graph.getVertice(14)));
        assertTrue(bfs.hasPath(graph.getVertice(14), graph.getVertice(11)));
    }
}
