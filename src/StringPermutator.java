import java.util.ArrayList;

public class StringPermutator {
    ArrayList permutate(String subject) {
        ArrayList<String> collector = new ArrayList();
        printPermutations(subject, "", collector);

        return collector;
    }

    void printPermutations(String subject, String answer, ArrayList<String> acc)  {
        if (subject.length() == 0) {
           acc.add(answer);
           return;
        }

        for (int i = 0; i < subject.length(); i++) {
            String ros = subject.substring(0, i) + subject.substring(i + 1);

            printPermutations(ros, answer + subject.charAt(i), acc);
        }
    }
}
