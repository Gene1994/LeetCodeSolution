/**
 * @author: create by Gene1994
 * @date:2018/11/9
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 LeetCode Problem No.382

 Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

 Example:

 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();
 */
public class LinkedListRandomNode {

    /**
     * Your Solution object will be instantiated and called as such:
     * LinkedListRandomNode obj = new LinkedListRandomNode(head);
     * int param_1 = obj.getRandom();
     */

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */



    List<Integer> list;
    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    //Wrong Anser 6/7
    /** Returns a random node's value. */
    public int getRandom() {
        int index = (int) Math.round(Math.random()*(list.size()-1));
        return list.get(index);
    }
}
