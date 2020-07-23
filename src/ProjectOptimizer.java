import java.util.ArrayList;
import java.util.HashMap;

public class ProjectOptimizer<T> {
    ArrayList<T> optimizedList = new ArrayList<>();

    public ArrayList<T> findCorrectBuildOrder(T[][] projects) {
        Graph graph = buildGraph(projects);

        ArrayList<Node> nonDependants = graph.getNonDependants();

        while (nonDependants.size() > 1) {
            for (Node node : nonDependants) {
                graph.removeEdge(node);
                for (Node child : node.children) {
                    child.removeParent();
                }
                optimizedList.add(node.value);
            }
            nonDependants = graph.getNonDependants();
        }

        return optimizedList;
    }

    private Graph buildGraph(T[][] projectList) {
        Graph graph = new Graph();
        for (T[] projects : projectList) {
            graph.addEdge(projects[0], projects[1]);
        }

        return graph;
    }

    private class Graph {
        HashMap<T, Node> edges = new HashMap<>();

        public void addEdge(T parent, T child) {
           Node node = getOrCreateNode(parent);

            node.addChild(getOrCreateNode(child));
        }

        public void removeEdge(Node node) {
            edges.remove(node.value);
        }

        public ArrayList<Node> getNonDependants() {
            ArrayList<Node> nodes = getNodes();

            nodes.removeIf(n -> n.dependencyCount > 0);

            return nodes;
        }

        public ArrayList<Node> getNodes() {
            return new ArrayList<>(edges.values());
        }

        private Node getOrCreateNode(T value) {
            if (edges.containsKey(value)) {
                return edges.get(value);
            }

            Node node = new Node(value);
            edges.put(value, node);
            return node;
        }
    }

    private class Node {
        T value;
        ArrayList<Node> children = new ArrayList<>();
        int dependencyCount = 0;

        Node(T value) {
            this.value = value;
        }

        public void addChild(Node child) {
            children.add(child);
            child.incrementDependencies();
        }

        public void removeParent() {
            this.decrementDependencies();
        }

        public void incrementDependencies() {
            this.dependencyCount++;
        }

        public void decrementDependencies() {
            this.dependencyCount--;
        }
    }
}
