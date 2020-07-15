import java.util.Objects;

public class BTNode<T> {
    public T value;
    public BTNode<T> left = null;
    public BTNode<T> right = null;
    public BTNode<T> parent = null;

    BTNode(T value) {
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
