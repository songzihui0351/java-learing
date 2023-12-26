package hot100;

public class DoubleLinkedNode {
    int key;
    int val;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;

    public DoubleLinkedNode() {
    }

    public DoubleLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
