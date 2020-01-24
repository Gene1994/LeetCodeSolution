package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author quzhe
 * @date 2020/1/22 12:39
 * @description 给定一个二叉树，返回它的中序 遍历。
 */
public class InorderTraversal {
    //递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    //迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    //颜色标记法
    public List<Integer> inorderTraversal3(TreeNode root) {
        if (root == null) { return new ArrayList<Integer>(); }

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            //这里修改顺序就可以改变遍历方式
            if (cn.color.equals("white")) {
                if (cn.node.right != null) { stack.push(new ColorNode(cn.node.right, "white")); }
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null) { stack.push(new ColorNode(cn.node.left, "white")); }
            } else {
                res.add(cn.node.val);
            }
        }

        return res;
    }

}
