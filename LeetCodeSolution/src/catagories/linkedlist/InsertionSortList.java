/**
 * @author: create by Gene1994
 * @date:2018/12/2
 */

import java.util.List;

/**
 * No147. Insertion Sort List
 *
 * 147. Insertion Sort List
 *
 Sort a linked list using insertion sort.

 Algorithm of Insertion Sort:

 Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 It repeats until no input elements remain.

 Example 1:
 Input: 4->2->1->3
 Output: 1->2->3->4

 Example 2:
 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        while (head != null){

        }
        return null;
    }
    public void insertListNode(ListNode head, ListNode listNode){
        while (head != null){
            if (head.next == null){
                head.next = listNode;
            }
            if (listNode.val >= head.val && listNode.val < head.next.val){
                listNode.next = head.next;
                head.next = listNode;
                break;
            }else if (listNode.val < head.val){
                listNode.next = head;
            }
        }
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode helper = new ListNode(0);//new starter of the sorted list
        ListNode cur = head;//the node will be inserted
        ListNode pre = helper;//insert node between pre and pre.next
        ListNode next = null;//the next node will be inserted
        //not the end of input list
        while (cur != null){
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }

            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;//?
            cur = next;
        }

        return helper.next;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        root.next = a;
        a.next = b;
//        root.next = a;
//        root = b;
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList1(root);
    }
}
