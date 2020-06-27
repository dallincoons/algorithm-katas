import java.util.HashMap;
import java.util.LinkedList;

public class BreadthFirstSearch {
    HashMap<Integer, Boolean> visited = new HashMap<>();

    private Graph g;

    public BreadthFirstSearch(Graph g) {
        this.g = g;
    }

    public boolean hasPath(Node start, Node end) {
        visited = new HashMap<>();

        if (start.equals(end)) {
            return true;
        }

        LinkedList<Node> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
           Node n = q.remove();

           if (visited.containsKey(n.name)) {
              continue;
           }

            for (Node adj : n.getAdjacency()) {
               if (visited.containsKey(n.name)) {
                   continue;
               }

               if (adj.equals(end)) {
                   return true;
               }

               q.add(adj);
           }

            visited.put(n.name, true);
        }

        return false;
    }
}
