package divideandconquer;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode build(int[] array) {
        ListNode head = this;
        ListNode curr = this;
        for (int val : array) {
            if (head == null) {
                head = new ListNode(val, null);
                curr = head;
            } else {
                curr.next = new ListNode(val, null);
                curr = curr.next;
            }
        }
        return this.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
