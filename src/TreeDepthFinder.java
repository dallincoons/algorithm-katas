import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeDepthFinder {
   public HashMap<Integer, ArrayList<BTNode>> depths = new HashMap<>();

   public HashMap<Integer, ArrayList<BTNode>> findDepths(BTNode node) {
      depths.put(0, new ArrayList<>(List.of(node)));

      findNextDepth(1, node);

      return depths;
   }

   private void findNextDepth(int depth, BTNode node) {
      if (node.left != null || node.right != null) {
          if (depths.get(depth) == null) {
             depths.put(depth, new ArrayList<>());
          }
      }
      if (node.left != null) {
         depths.get(depth).add(node.left);
         findNextDepth(depth + 1, node.left);
      }

      if (node.right != null) {
         depths.get(depth).add(node.right);
         findNextDepth(depth + 1, node.right);
      }
   }
}
