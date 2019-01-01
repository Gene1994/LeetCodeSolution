package tree;

import java.util.*;

/**
 * @author: create by Gene1994
 * @date:2018/12/16
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Map<Integer, TreeNode>> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);
        q.add(map);

        int level = 0;
//        while (!q.isEmpty()){
//            TreeNode treeNode = q.poll().);
//            level = map.get(treeNode) + 1;
//
//            if (treeNode.left != null){
//                q.add(treeNode.left);
//                map.put(treeNode.left, level);
//            }
//
//
//            if (treeNode.right != null){
//                q.add(treeNode.right);
//                map.put(treeNode.right, level);
//            }
//
//        }
//        for (int i = 0; i <= level; i++){
//            if (map.)
//        }
        return null;

    }

    public static void main(String[] args) {
        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        char a= 'a', b =  'b',c;
//        b6=b4+b5;
////        b3=(b1+b2);
//        c = a+b;
//        System.out.println(b3+b6);
    }
}
