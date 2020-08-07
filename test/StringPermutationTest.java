import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class StringPermutationTest {
    @Test
    public void PrintAllStringPermutations() {
         StringPermutator p = new StringPermutator();

        ArrayList answer = p.permutate("abc");

        assertEquals(6, answer.size());

        answer = p.permutate("dallin");
        assertEquals(720, answer.size());
    }
}
