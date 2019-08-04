package leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */

public class Test0019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer, ListNode> m = new HashMap<Integer, ListNode>();
        int index = 1;
        while (temp != null) {
            m.put(index++, temp);
            temp = temp.next;
        }
        int size = m.size();
        if (size == 1)
            return null;
        if (n == 1) {
            m.get(size - 1).next = null;
        } else if (n == size) {
            head = head.next;
        } else {
            m.get(size - n).next = m.get(size - n + 2);
        }
        return head;
    }

}
