package LinkedList;

import java.util.Arrays;
import java.util.List;

public class Reverse_LinkedList_206 {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3);
        ListNode list = ListNode.listBuilder(array);
        ListNode ret = reverseList(list);
        ListNode.listPrinter(ret);
    }

    // 1 -> 2 -> 3
    // 3 -> 2 -> 1
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;
        while (second.next != null) {
            ListNode third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        second.next = first;
        return second;
    }
}
