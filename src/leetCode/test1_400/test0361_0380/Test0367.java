package leetCode.test1_400.test0361_0380;

/**
 * @author nimingxiong
 * Created at 2020/6/26 21:20
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 示例 1：
 * 输入：16
 * 输出：True
 * 示例 2：
 * 输入：14
 * 输出：False
 */

public class Test0367 {
    public static boolean isPerfectSquare(int num) {
        if (1 == num) return true;
        int i = num / 2;
        while ((double) i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
