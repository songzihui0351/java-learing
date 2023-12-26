package divideandconquer;

public class SortLinkedList_148 {
    public static void main(String[] args) {
        int[] nodes = {4, 2, 1, 3};
        ListNode head = new ListNode().build(nodes);
        System.out.println(sortList(head));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode(head.val, null);
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(right));
    }

    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = new ListNode(left.val, null);
                left = left.next;
            } else {
                curr.next = new ListNode(right.val, null);
                right = right.next;
            }
            curr = curr.next;
        }

        if (left == null) {
            curr.next = right;
        } else {
            curr.next = left;
        }

        return head.next;
    }

}
