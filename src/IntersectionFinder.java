import java.util.Iterator;
import java.util.LinkedList;

public class IntersectionFinder {
    public int findIntersection(LinkedList listA, LinkedList listB) {
        if (listA.isEmpty() || listB.isEmpty()) {
            return -1;
        }

        int difference = Math.abs(listA.size() - listB.size());
        LinkedList bigger = listA;
        LinkedList smaller = listB;

        if (listB.size() > listA.size()) {
            bigger = listB;
            smaller = listA;
        }

        Iterator s = smaller.iterator();
        Iterator b = bigger.iterator();

        for (int i = 0; i < smaller.size(); i++) {
            if (smaller.get(i) == bigger.get(i + difference)) {
                return (int)smaller.get(i);
            }
        }

        return -1;
    }
}
