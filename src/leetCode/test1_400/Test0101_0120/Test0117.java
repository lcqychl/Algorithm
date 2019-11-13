package leetCode.test1_400.Test0101_0120;

/*
* 给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
示例：
输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
* */

public class Test0117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Node pre = root;
        Node cur = null;
        while (true) {
            cur = pre;
            while (cur != null) {
                //找到至少有一个孩子的节点
                if (cur.left == null && cur.right == null) {
                    cur = cur.next;
                    continue;
                }
                //找到当前节点的下一个至少有一个孩子的节点
                Node next = cur.next;
                while (next != null && next.left == null && next.right == null) {
                    next = next.next;
                    if (next == null) {
                        break;
                    }
                }
                //当前节点的左右孩子都不为空，就将 left.next 指向 right
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                //要接上 next 的节点的孩子，所以用 temp 处理当前节点 right 为 null 的情况
                Node temp = cur.right == null ? cur.left : cur.right;

                if (next != null) {
                    //next 左孩子不为 null，就接上左孩子。
                    if (next.left != null) {
                        temp.next = next.left;
                        //next 左孩子为 null，就接上右孩子。
                    } else {
                        temp.next = next.right;
                    }
                }

                cur = cur.next;
            }
            //找到拥有孩子的节点
            while (pre.left == null && pre.right == null) {
                pre = pre.next;
                //都没有孩子说明已经是最后一层了
                if (pre == null) {
                    return root;
                }
            }
            //进入下一层
            pre = pre.left != null ? pre.left : pre.right;
        }
    }
}
