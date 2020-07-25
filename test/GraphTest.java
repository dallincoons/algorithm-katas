import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void getGraphAdjacency() {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertEquals(new ArrayList<Integer>(List.of(2,3)), graph.getAdjacency(1));
    }

    @Test
    public void getNodeAdjacency() {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(10, 11);

        assertEquals(new ArrayList<>(List.of(new Node(2, graph), new Node(3, graph))), graph.getVertice(1).getAdjacency());
        assertEquals(new ArrayList<>(List.of(new Node(1, graph), new Node(3, graph))), graph.getVertice(2).getAdjacency());
        assertEquals(new ArrayList<>(List.of(new Node(11, graph))), graph.getVertice(10).getAdjacency());
        assertEquals(new ArrayList<>(List.of(new Node(10, graph))), graph.getVertice(11).getAdjacency());
    }
}
