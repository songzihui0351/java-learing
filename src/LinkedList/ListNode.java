package LinkedList;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode listBuilder(List<Integer> array) {
        if (array.isEmpty()) {
            System.out.println("Array is empty!");
            return null;
        }
        ListNode head = new ListNode(array.get(0), null);
        ListNode pointer = head;
        for (int i = 1; i < array.size(); i++) {
            pointer.next = new ListNode(array.get(i), null);
            pointer = pointer.next;
        }
        return head;
    }

    public static void listPrinter(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + " -> ");
            } else {
                System.out.println(head.val);
            }
            head = head.next;
        }
    }
}
