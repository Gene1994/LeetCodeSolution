package tree;

import common.TreeNode;

/**
 * @author quzhe
 * @date 2020/1/21 13:00
 * @description 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/path-sum-iii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    //双递归
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //注意不是sum(root, sum)+ sum(root.left,sum) + sum(root.right, sum)
        return sum(root, sum)+ pathSum(root.left,sum) + pathSum(root.right, sum);
    }

    /**
     * 计算以root为起点 有多少个和为sum的
     * @param root
     * @param sum
     * @return
     */
    private static int sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += sum(root.left, sum - root.val);
        res += sum(root.right, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.left.left = new TreeNode(5);
        System.out.println(pathSum(treeNode, 3));
    }
}
