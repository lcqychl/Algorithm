package leetCode.test1_400.test0201_0220;

import leetCode.ListNode;

/**
 * @author nimingxiong
 * Created at 2020/3/4 21:21
 * 
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 迭代或递归地反转链表
 */

public class Test0206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
