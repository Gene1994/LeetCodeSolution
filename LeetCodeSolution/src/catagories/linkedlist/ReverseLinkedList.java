/**
 * @author: create by Gene1994
 * @date:2018/12/2
 */

/**
 * No.206 Reverse Linked List
 *
 * Difficulty:Easy
 *
 Reverse a singly linked list.

 Example:
 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur.next != null){
            ListNode nextTmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTmp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        root.next = a;
        a.next = b;
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode res = r.reverseList1(root);
    }
}
