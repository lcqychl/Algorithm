package leetCode;

import leetCode.test1_400.test0121_0140.Test0133;

import java.util.List;

/**
 * @author nimingxiong
 * @date 2019/12/21 16:00
 */
public class Node {
    public int val;
    public Node next;
    public Node random;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
