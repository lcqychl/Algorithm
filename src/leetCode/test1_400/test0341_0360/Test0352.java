package leetCode.test1_400.test0341_0360;

import java.util.TreeMap;

/**
 * @author nimingxiong
 * Created at 2020/6/21 20:52
 *
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 */

public class Test0352 {
    private class Node {
        int left, right;
        Node next;

        public Node(int left, int right, Node next) {
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    private TreeMap<Integer, Node> treeMap;

    private Node dummy;

    private int count;

    /**
     * Initialize your data structure here.
     */
    public Test0352() {
        treeMap = new TreeMap<>();
        dummy = new Node(-2, -2, null);
        treeMap.put(-2, dummy);
        count = 0;
    }

    public void addNum(int val) {
        Node pre = treeMap.lowerEntry(val).getValue();
        Node cur = pre.next;
        if (cur != null && cur.left <= val) {
            return;
        }
        boolean isNull = cur == null;
        if (isNull) {
            cur = new Node(val + 2, val + 2, null);
        }
        if (pre.right + 1 == val) {
            if (val + 1 == cur.left) {
                treeMap.remove(pre.right);
                treeMap.remove(cur.right);
                pre.right = cur.right;
                pre.next = cur.next;
                treeMap.put(cur.right, pre);
                count--;
            } else {
                treeMap.remove(pre.right);
                pre.right++;
                treeMap.put(pre.right, pre);
            }
        } else if (val + 1 == cur.left) {
            cur.left--;
        } else {
            Node node = new Node(val, val, isNull ? null : cur);
            treeMap.put(val, node);
            count++;
            pre.next = node;
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[count][2];
        Node node = dummy.next;
        int id = 0;
        while (node != null) {
            res[id++] = new int[]{node.left, node.right};
            node = node.next;
        }
        return res;
    }
}
