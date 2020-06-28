package leetCode.test1_400.test0361_0380;

/**
 * @author nimingxiong
 * Created at 2020/6/28 23:30
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */

public class Test0371 {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int lower;
        int carrier;
        while (true) {
            lower = a ^ b;    // 计算低位
            carrier = a & b;  // 计算进位
            if (carrier == 0) break;
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }
}
