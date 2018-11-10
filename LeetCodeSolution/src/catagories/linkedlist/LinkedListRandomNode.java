/**
 * @author: create by Gene1994
 * @date:2018/11/9
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 LeetCode Problem No.382 LinkedListRandomNode

 Difficulty:Medium

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

/////////////////////////////////////////////////////////////////////////////////
//My solution, Wrong Anser (6/7)
    List<Integer> list;
    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = (int) Math.round(Math.random()*(list.size()-1));
        return list.get(index);
    }

/////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////

    //most popular solution
//    @author : hot13399
    /*
    Explanation:

    When we read the first node head, if the stream ListNode stops here, we can just return the head.val. The possibility is 1/1.

    When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace r as the value of the current node, otherwise we don't touch r, so its value is still the value of head.

    When we read the third node, now the result r is one of value in the head or second node. We just decide if we replace the value of r as the value of current node(third node). The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.

    We can continue to do like this until the end of stream ListNode.
     */
//    ListNode head;
//    Random random;
//
//    public Solution(ListNode h) {
//        head = h;
//        random = new Random();
//    }
//
//    public int getRandom() {
//
//        ListNode c = head;
//        int r = c.val;
//        for(int i=1;c.next != null;i++){
//            c = c.next;
//            if(random.nextInt(i + 1) == i)
//              r = c.val;
//        }
//
//        return r;
//    }
/////////////////////////////////////////////////////////////////////////////////
}
