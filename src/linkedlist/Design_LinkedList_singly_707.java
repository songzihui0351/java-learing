package linkedlist;

public class Design_LinkedList_singly_707 {

    private final ListNode head;
    private int size;

    public Design_LinkedList_singly_707() {
        head = new ListNode(0, null);
        size = 0;
    }

    public static void main(String[] args) {
        Design_LinkedList_singly_707 head = new Design_LinkedList_singly_707();
        head.addAtHead(7);
        head.addAtHead(2);
        head.addAtHead(1);
        head.addAtIndex(3, 0);
        head.deleteAtIndex(2);
        head.addAtHead(6);
        head.addAtTail(4);
        System.out.println(head.get(4));
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode pointer = head;
        for (int i = 0; i <= index; i++) {
            pointer = pointer.next;
        }
        return pointer.val;
    }

    public void addAtHead(int val) {
        ListNode temp = head.next;
        head.next = new ListNode(val, temp);
        size++;
    }

    public void addAtTail(int val) {
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new ListNode(val, null);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        ListNode temp = pointer.next;
        pointer.next = new ListNode(val, temp);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        size--;
    }
}
