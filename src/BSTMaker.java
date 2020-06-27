public class BSTMaker {
    public BTNode makeBST(int[] arr) {
        return this.constructBST(arr, 0, arr.length - 1);
    }

    private BTNode constructBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        BTNode node = new BTNode(arr[mid]);

        node.left = constructBST(arr, start, mid - 1);
        node.right = constructBST(arr, mid + 1, end);

        return node;
    }
}
