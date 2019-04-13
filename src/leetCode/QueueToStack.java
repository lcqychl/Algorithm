package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack<T> {
    private final Queue<T> queue1= new LinkedList<>();
    private final Queue<T> queue2= new LinkedList<>();

    // 元素入栈
    public void push(T t) {
        if (!queue1.isEmpty()){
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            queue1.offer(t);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }else{
            queue1.offer(t);
        }
    }

    // Removes the element on top of the stack and returns that element.
    public T pop() {
        if (queue1.isEmpty()){
            return null;
        }
        return queue1.poll();
    }

    //Get the top element.
    public T top() {
        if (queue1.isEmpty()){
            return null;
        }
        return queue1.peek();
    }

    //Returns whether the stack is empty.
    public boolean isEmpty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        QueueToStack<Integer> s=new QueueToStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.push(4);
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
