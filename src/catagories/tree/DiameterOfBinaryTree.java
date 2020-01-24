package tree;

import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @author quzhe
 * @date 2020/1/20 10:44
 * @description 543. 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */

public class DiameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return res;
    }


    /**
     * depth
     */
    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int l = depth(treeNode.left);
        int r = depth(treeNode.right);
        res = Math.max(res, l+r);
        return Math.max(l,r) + 1;
    }
}
