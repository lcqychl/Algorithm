package leetCode.test1_400.test0141_0160;

import leetCode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author nimingxiong
 * @date 2019/12/26 16:19
 */
public class Test0148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head !=null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        return createLinkedList(list);
    }
    // list递归转链表
    private ListNode createLinkedList(List<Integer> data) {
        if(data.isEmpty()) {	//如果为空返回null
            return null;
        }
        ListNode firstNode = new ListNode(data.get(0));	//每次取第一个元素
        firstNode.next = createLinkedList(data.subList(1, data.size()));//第二个元素从下标为1开始取余下list
        return firstNode;
    }
}
