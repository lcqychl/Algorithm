package leetCode.test1_400.test0301_0320;

/**
 * @author nimingxiong
 * Created at 2020/5/6 21:07
 *
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 示例 1:
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 */
public class Test0306 {
    long[] path;

    public boolean isAdditiveNumber(String num) {
        char[] chars = num.toCharArray();
        path = new long[1000];
        return dfs(chars, 0, 0);
    }

    public boolean dfs(char[] chars, int start, int index) {
        if (start == chars.length) {
            //到达终点，判断是否有至少 3 个数
            return index > 2;
        }
        long num = 0;
        //用 len 来判断是否存在 01 这种情况
        int len = 0;
        for (int i = start; i < chars.length; i++) {
            num *= 10;
            num += chars[i] - '0';
            len++;
            if (String.valueOf(num).length() < len) {
                //出现了 01 这种情况，是不允许的，直接返回 false
                return false;
            }
            path[index] = num;
            //如果当前的累加数个数小于 3 个，就不用判断是否满足构成累加数的要求
            if (index < 2) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
                continue;
            }
            //当前的累加数个数大于等于 3 个，需要判断是否满足条件
            if (path[index] == path[index - 1] + path[index - 2]) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
