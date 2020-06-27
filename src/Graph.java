import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Graph {
    HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();

    public void addEdge(int v, int w) {
        if (!nodes.containsKey(v)) {
            nodes.put(v, new ArrayList<Integer>(List.of()));
        }

        if (!nodes.containsKey(w)) {
            nodes.put(w, new ArrayList<Integer>(List.of()));
        }

        nodes.get(v).add(w);
        nodes.get(w).add(v);
    }

    public ArrayList<Integer> getAdjacency(int v) {
        if (!nodes.containsKey(v)) {
            throw new InvalidParameterException("No vertice found for key: " + v);
        }

        return nodes.get(v);
    }

    public Node getVertice(int v) {
        if (!nodes.containsKey(v)) {
            throw new InvalidParameterException("No vertice found for key: " + v);
        }

        return new Node(v, this);
    }
}
