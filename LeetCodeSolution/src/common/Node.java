import java.util.List;

/**
 * @author: create by Gene1994
 * @date:2019/1/1
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
