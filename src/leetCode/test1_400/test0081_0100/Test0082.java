package leetCode.test1_400.test0081_0100;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */

public class Test0082 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归写法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //去掉所有重复的数字，然后进行递归
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    //非递归写法
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode node = res;
        while (head != null) {
            boolean dup = false;
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
                dup = true;
            }
            if (!dup) {
                res.next = head;
                res = res.next;

            }
            head = head.next;
        }
        res.next = null;  //防止res后面还有重复的节点
        return node.next;
    }
}
