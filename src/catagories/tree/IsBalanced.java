package tree;

import common.TreeNode;

/**
 * @author quzhe
 * @date 2020/1/27 13:13
 * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
            && isBalanced(root.left) && isBalanced(root.right);

    }
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left) , depth(root.right));
    }
}
