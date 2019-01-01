/**
 * @author: create by Gene1994
 * @date:2018/12/15
 */

/**
 *
 * No.24
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        pre.next = head;
        while (pre.next != null && pre.next.next != null){
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = pre.next.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next=b;b.next=c;c.next=d;
        SwapNodesInPairs s = new SwapNodesInPairs();
        s.swapPairs(a);
    }
}
