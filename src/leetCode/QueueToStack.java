package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    //Initialize your data structure here.
    public QueueToStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 元素入栈 Push element x onto stack.
    public void push(int x) {
        if (queue1.peek() != null){
            while (queue1.peek() != null) {
                queue2.offer(queue1.poll());
            }
            queue1.offer(x);
            while (queue2.peek() != null) {
                queue1.offer(queue2.poll());
            }
        }else{
            queue1.offer(x);
        }
    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        if (queue1.peek() == null){
            return 0;
        }
        return queue1.poll();
    }

    //Get the top element.
    public int top() {
        if (queue1.peek() == null){
            return 0;
        }
        return queue1.peek();
    }

    //Returns whether the stack is empty.
    public boolean empty() {
        return queue1.peek() == null;
    }
}
