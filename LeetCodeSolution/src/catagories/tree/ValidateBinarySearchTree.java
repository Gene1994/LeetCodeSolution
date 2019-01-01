package tree;

/**
 * @author: create by Gene1994
 * @date:2018/12/15
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * No.98
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return go(root, null, null);
    }

    public boolean go(TreeNode root, Integer max, Integer min){
        if (root == null){
            return true;
        }
        if (max != null && root.val >= max)
            return false;
        if (min != null && root.val <= min)
            return false;
        boolean left = go(root.left, root.val, null);
        if (left){
            boolean right = go(root.right, null, root.val);
            return right;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left=b;a.right=c;
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        System.out.println(s.isValidBST1(a));
    }

    //中序遍历法
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST1(TreeNode root) {
        if (initList(root)){
            List<Integer> list1 = new ArrayList<>();
            for (int t : list){
                list1.add(t);
            }
            list1.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return list.equals(list1);
        }else {
            return false;
        }

    }
    public boolean initList(TreeNode root){
        if (root == null)
            return true;
        if (root.left != null){
            initList(root.left);
        }
        if (list.contains(root.val)){
            return false;
        }else {
            list.add(root.val);
        }
        if (root.right != null){
            initList(root.right);
        }
        return true;
    }
}
