package tree;

import common.TreeNode;

/**
 * @author quzhe
 * @date 2020/1/27 13:49
 * @description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return 1 + Math.min(minDepth(root.left) , minDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(root));
    }
}
