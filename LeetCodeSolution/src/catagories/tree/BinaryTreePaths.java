package tree;

/**
 * @author: create by Gene1994
 * @date:2019/1/1
 */

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * No.257 Binary Tree Paths
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dps(root, "");
        return res;
    }

    private void dps(TreeNode root, String sb) {
        if (root !=  null) {
            sb += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                res.add(sb.toString());
            }else {

                sb += "->";
                dps(root.left, sb);
                dps(root.right, sb);
            }
        }

    }
}
