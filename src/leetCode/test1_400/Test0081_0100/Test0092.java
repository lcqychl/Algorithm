package leetCode.test1_400.Test0081_0100;

/*
* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:
1 ≤ m ≤ n ≤ 链表长度。
示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
* */

public class Test0092 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }

        right = right.next;

        if (m > 1) {
            this.left = this.left.next;
        }

        this.recurseAndReverse(right, m - 1, n - 1);

        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

}
