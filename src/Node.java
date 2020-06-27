import java.util.ArrayList;
import java.util.Objects;

public class Node {
    public int name;
    private Graph graph;

    Node(int name, Graph graph) {
        this.name = name;
        this.graph = graph;
    }

    public ArrayList<Node> getAdjacency() {
        ArrayList<Node> list = new ArrayList<>();

        for (int v : graph.getAdjacency(name)) {
            list.add(new Node(v, graph));
        }

        return list;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return name == node.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
