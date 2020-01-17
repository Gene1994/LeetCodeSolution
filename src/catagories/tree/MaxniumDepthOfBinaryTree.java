package tree;

/**
 * @author: create by Gene1994
 * @date:2018/12/15
 */



import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * No.104
 */
public class MaxniumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;


    }

    //BFS
    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()){
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode treeNode = q.poll();
                if (treeNode.left != null)
                    q.add(treeNode.left);
                if (treeNode.right != null)
                    q.add(treeNode.right);

            }
        }
        return res;
    }

    //DFS
    public int maxDepth2(TreeNode root) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        if(root == null)
            return max;
        int depth = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){

            TreeNode treeNode = stack.pop();
            depth++;
            if (treeNode.left == null && treeNode.right == null){
                max = Math.max(depth, max);
                min = Math.min(depth, min);

            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            depth--;
        }
        return max;
    }
}
