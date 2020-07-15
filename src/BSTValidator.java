public class BSTValidator {
    private Integer lastValue;
    public boolean isValidBST(BTNode<Integer> node) {
        if (node == null) {
            return true;
        }

        if (!isValidBST(node.left)) {
           return false;
        }

        if (lastValue != null && node.value < lastValue) {
           return false;
        }

        lastValue = node.value;

        if(!isValidBST(node.right)) {
            return false;
        }

        return true;
    }

    public boolean isValidBSTMinMax(BTNode<Integer> node) {
        return checkValidSubtree(node.left, new MinMax(Integer.MIN_VALUE, node.value)) && checkValidSubtree(node.right, new MinMax(node.value, Integer.MAX_VALUE));
    }

    private boolean checkValidSubtree(BTNode<Integer> node, MinMax minMax) {
        if (node == null) {
            return true;
        }

        if (node.value > minMax.max || node.value < minMax.min) {
            return false;
        }

        if (!checkValidSubtree(node.left, new MinMax(minMax.min, node.value))) {
            return false;
        }

        if (!checkValidSubtree(node.right, new MinMax(node.value, minMax.max))) {
            return false;
        }

        return true;
    }

    private class MinMax {
        public int min;
        public int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
