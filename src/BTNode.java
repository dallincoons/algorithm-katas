import java.util.Objects;

public class BTNode {
    public int value;
    public BTNode left = null;
    public BTNode right = null;

    BTNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        BTNode node = (BTNode) obj;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
