package leetCode.test1_400.test0241_0260;

/**
 * @author nimingxiong
 * Created at 2020/4/14 20:27
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题
 */
public class Test0258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
