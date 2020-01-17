/**
 * @author: create by Gene1994
 * @date:2018/11/10
 */

import common.ListNode;

/**
 * No.2 Add Two Numbers
 *
 * Difficulty:Medium
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */
public class AddTwoNumbers {
    //My solution(77ms)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    /*
    Official solution
    Complexity Analysis

    Time complexity : O(max(m,n)). Assume that m and n represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.

    Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //fastest(26ms)
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode resultTop = new ListNode(0);
        ListNode resultTail = resultTop;
        int leading = 0;
        while(index1 != null || index2 != null || leading != 0){
            leading = (index1==null?0:index1.val)+(index2==null?0:index2.val)+leading;
            ListNode temp = new ListNode(leading%10);
            leading /= 10 ;
            resultTail.next = temp;
            resultTail = temp;
            index1 = (index1==null)?null:index1.next;
            index2 = (index2==null)?null:index2.next;
        }
        resultTop = resultTop.next;
        return resultTop;
    }
}
