package DivideAndConquer;

/*
    有序链表转化为平衡BST
    复习知识点: 1.构造链表 2.快慢指针条件
    递归左右链表时确定右边界:
        右链表: 右链表start=左链表stop.next
        左链表: 左链表stop.next=null
 */
public class SortedList2BST_109 {
    public static void main(String[] args) {
        int[] nodeList = {-10, -3, 0, 5, 9};
        ListNode head = new ListNode().build(nodeList);
        System.out.println(sortedListToBST(head));
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        ListNode post = slow.next;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(post);

        return root;
    }
}
