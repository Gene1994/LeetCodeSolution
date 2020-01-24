package tree;

import common.TreeNode;

/**
 * @author quzhe
 * @date 2020/1/17 16:11
 * @description tree
 */
/*
翻转一棵二叉树。
 */
public class InvertBinartTree {
    //my solution ： 当成对象
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        //if (root.left == null && root.right == null) {
        //    return root;
        //}
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        TreeNode t1l = new TreeNode(3);
        //TreeNode t1r = new TreeNode(2);
        t1.left = t1l;
        //t1.right = t1r;
        //t1.left.left = new TreeNode(5);
        invertTree(t1);
    }
}
