import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LinkedListIntersectionTest {
    @Test
    public void emptyListsFindNoIntersection() {
        LinkedList<Integer> listA = buildLinkedList(new Integer[]{1});
        LinkedList<Integer> listB = buildLinkedList(new Integer[]{});

        IntersectionFinder finder = new IntersectionFinder();

        assertEquals(-1, finder.findIntersection(listA, listB));
    }

    @Test
    public void findIntersectionBetweenTwoLinkedLists() {
        LinkedList<Integer> listA = buildLinkedList(new Integer[]{3,1,5,9,7,2,1});
        LinkedList<Integer> listB = buildLinkedList(new Integer[]{4,6,7,2,1});

        IntersectionFinder finder = new IntersectionFinder();

        int intersect = finder.findIntersection(listA, listB);

        assertEquals(7, intersect);
    }

    @Test
    public void findIntersectionAtTheVeryEnd() {
        LinkedList<Integer> listA = buildLinkedList(new Integer[]{3,1,5,9,8,9,1});
        LinkedList<Integer> listB = buildLinkedList(new Integer[]{4,6,7,2,1});

        IntersectionFinder finder = new IntersectionFinder();

        int intersect = finder.findIntersection(listA, listB);

        assertEquals(1, intersect);
    }

    @Test
    public void findThatThereIsNoIntersectionFromDifferentLengthLists() {
        LinkedList<Integer> listA = buildLinkedList(new Integer[]{3,1,5,9,8,9,2});
        LinkedList<Integer> listB = buildLinkedList(new Integer[]{4,6,7,2,1});

        IntersectionFinder finder = new IntersectionFinder();

        int intersect = finder.findIntersection(listA, listB);

        assertEquals(-1, intersect);
    }

    private LinkedList buildLinkedList(Integer[] values) {
        LinkedList<Integer> list = new LinkedList<>();

        for (Integer value : values) {
            list.add(value);
        }

        return list;
    }
}
