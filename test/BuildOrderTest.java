import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildOrderTest {
    @Test
    public void findOrderInWhichProjectsCanBeBuilt() {
        ProjectOptimizer<Character> optimizer = new ProjectOptimizer();

        Character[][] projectList = {
            {'f', 'b'},
            {'f', 'c'},
            {'c', 'a'},
            {'b', 'a'},
            {'b', 'a'},
            {'a', 'e'},
            {'d', 'g'},
        };

        ArrayList<Character> optimizedList = optimizer.findCorrectBuildOrder(projectList);

        ArrayList<Character> expected = new ArrayList<>();
        expected.add('d');
        expected.add('f');
        expected.add('b');
        expected.add('c');
        expected.add('g');
        expected.add('a');
        expected.add('e');

        assertEquals(expected, optimizedList);
    }

    @Test
    public void getTwoProjectsInCorrectOrder() {
        ProjectOptimizer<Character> optimizer = new ProjectOptimizer();

        Character[][] projectList = {
                {'d', 'g'},
        };

        ArrayList<Character> optimizedList = optimizer.findCorrectBuildOrder(projectList);

        ArrayList<Character> expected = new ArrayList<>();
        expected.add('d');
        expected.add('g');

        assertEquals(expected, optimizedList);
    }

    @Test
    public void cycleIsDetectedInBuildOrder() {
        ProjectOptimizer<Character> optimizer = new ProjectOptimizer();

        Character[][] projectList = {
                {'d', 'g'},
                {'g', 'e'},
                {'e', 'd'},
                {'j', 'k'},
        };

        ArrayList<Character> optimizedList = optimizer.findCorrectBuildOrder(projectList);

        assertNull(optimizedList);
    }
}
