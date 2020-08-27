import java.util.ArrayList;
import java.util.LinkedList;

public class BSTInitialArrays {
    ArrayList<LinkedList<Integer>> allSequences(BTNode<Integer> node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
           result.add(new LinkedList<>());
           return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();

                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        prefix.addLast(first.removeFirst());
        weaveLists(first, second, results, prefix);
        first.addFirst(prefix.removeLast());

        prefix.addLast(second.removeFirst());
        weaveLists(first, second, results, prefix);
        second.addFirst(prefix.removeLast());
    }
}
