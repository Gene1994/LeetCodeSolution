package tree;

/**
 * @author: create by Gene1994
 * @date:2018/11/29
 */

import common.TreeNode;

import java.security.KeyStore;
import java.util.LinkedList;
import java.util.Queue;

/**
 * No.662. Maximum Width of Binary Tree
 * Difficulty:Medium
 *
 Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

 The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

 Example 1:
 Input:

           1
        /   \
      3     2
    / \     \
  5   3     9

 Output: 4
 Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).


 Example 2:
 Input:

        1
      /
     3
   / \
 5   3

 Output: 2
 Explanation: The maximum width existing in the third level with the length 2 (5,3).

 Example 3:
 Input:

       1
     / \
   3   2
  /
 5

 Output: 2
 Explanation: The maximum width existing in the second level with the length 2 (3,2).


 Example 4:
 Input:

         1
       / \
     3   2
    /     \
   5       9
 /         \
6           7
 Output: 8
 Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


 */
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    public static Class gg(){
        return MaximumWidthofBinaryTree.class;
//        return this.getClass();
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3l;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));
//        System.out.println(gg().toString());
        int s = 3;
        System.out.println(s == g);

        while (s == 1){
            System.out.println("");
        }
    }



//    true
//    false
//    true
//    true
//    false
//    true
}
