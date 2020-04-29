package leetCode.test1_400.test0281_0300;

import java.util.PriorityQueue;

/**
 * @author nimingxiong
 * Created at 2020/4/29 20:15
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class Test0295 {

    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public Test0295() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());

        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {

            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {

            return (double) maxheap.peek();
        }
    }
}
