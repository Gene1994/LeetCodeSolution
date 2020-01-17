/**
 * @author: create by Gene1994
 * @date:2018/12/2
 */

import common.ListNode;

/**
 * No.21 Merge Two Sorted Lists
 *
 * Difficulty:Easy
 *
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:
 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                 pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;

        }
        if (l1 != null){
            pre.next = l1;
        }
        if (l2 != null){
            pre.next = l2;
        }
        return res.next;
    }
}
