package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author quzhe
 * @date 2020/1/25 22:20
 * @description 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    list.add("x");
                } else {
                    list.add(String.valueOf(poll.val));
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }

            for (int i = 0; i < list.size()/2; i++) {
                if (!list.get(i).equals(list.get(list.size()-1-i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(-3);
        root.right.left = new TreeNode(-3);
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(root));
    }
}
