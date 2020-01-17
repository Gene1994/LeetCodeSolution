package tree;

/**
 * @author: create by Gene1994
 * @date:2019/1/1
 */

import common.Node;

import java.util.*;

/**
 * No.589 N-ary Tree Preorder Traversal
 *
 */
public class NaryTreePreorderTraversal {
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> preorder(common.Node root) {
//        if (root == null)
//            return res;
//        go(root, res);
//       return res;
//    }
//    private void go(common.Node root, List list) {
//        res.add(root.val);
//        if (root.children != null) {
//            for (common.Node n : root.children) {
//                go(n, res);
//            }
//        }
//    }
    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size()-1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }
}
