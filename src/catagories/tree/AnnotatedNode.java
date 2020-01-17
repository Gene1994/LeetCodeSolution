package tree;

import common.TreeNode;

/**
 * @author: create by Gene1994
 * @date:2018/11/29
 */
public class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}