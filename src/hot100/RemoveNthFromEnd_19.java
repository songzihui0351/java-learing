package hot100;

import divideandconquer.ListNode;

import java.util.Stack;

/*
    快慢指针: 不一定是步长为两倍, 可以是初始值相差n, 步长一样来获取n个节点
 */

public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode().build(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        System.out.println(removeNthFromEndStack(head, n));
        System.out.println(removeNthFromEndDoublePointer(head, n));
    }

    private static ListNode removeNthFromEndDoublePointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndStack(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0, head);
        ListNode pointer = dummy;
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;

        return dummy.next;
    }
}
