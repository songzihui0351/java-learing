package LinkedList;

import java.util.Arrays;
import java.util.List;

public class Remove_Element_203 {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 1);
        ListNode list = ListNode.listBuilder(array);
        ListNode.listPrinter(list);
        ListNode ret = new Remove_Element_203().removeElements(list, 1);
        ListNode.listPrinter(ret);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode pointer = dummy;
        while (pointer != null) {
            if (pointer.next != null && pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
}
