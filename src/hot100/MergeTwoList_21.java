package hot100;

import divideandconquer.ListNode;

/*
    递归!!!
 */

public class MergeTwoList_21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode().build(new int[]{1, 2, 4});
        ListNode l2 = new ListNode().build(new int[]{1, 3, 4});
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
