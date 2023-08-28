package DoublePointers;

/*
    有向图判断是否有环
 */

class ListNode {
    int val;
    ListNode next;
}

public class LinkedListCycle_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}

/*
    注意与的判断条件 && 为两个条件都判断, 容易出错, 可以将逻辑替换为或 ||
 */
