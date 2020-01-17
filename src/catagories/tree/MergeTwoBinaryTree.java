package tree;

import common.TreeNode;

/**
 * @author quzhe
 * @date 2020/1/17 14:30
 * @description tree
 */
/*
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoBinaryTree {
    /**
     * my solution: 迭代
     * 如果一方为空令一方不为空 直接返回不为空的node就好
     * 不需要新建node(line38)直接在t1或者t2上操作就可以
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            t1 = new TreeNode(0);
        }
        if (t2 == null) {
            t2 = new TreeNode(0);
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    public static void main(String[] args) {
        /*

	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        TreeNode t1l = new TreeNode(3);
        TreeNode t1r = new TreeNode(2);
        t1.left = t1l;
        t1.right = t1r;
        t1.left.left = new TreeNode(5);

        TreeNode t2l = new TreeNode(1);
        TreeNode t2r = new TreeNode(3);
        t2.left = t2l;
        t2.right = t2r;
        t2l.right = new TreeNode(4);
        t2r.right = new TreeNode(7);

        TreeNode treeNode = mergeTrees(t1, t2);
        System.out.println(treeNode.left.right.val);;
    }
}
