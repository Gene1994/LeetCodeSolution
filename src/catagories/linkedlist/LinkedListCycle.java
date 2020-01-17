/**
 * @author: create by Gene1994
 * @date:2018/12/2
 */

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * No.141 Linked List Cycle
 *
 * Difficulty:Easy
 *
 Given a linked list, determine if it has a cycle in it.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
