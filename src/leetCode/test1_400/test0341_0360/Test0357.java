package leetCode.test1_400.test0341_0360;

/**
 * @author nimingxiong
 * Created at 2020/6/18 19:46
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class Test0357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n > 10) {
            n = 10;
        }
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 91;
        }
        int dp[] = new int[11];
        dp[1] = 10;
        dp[2] = 81;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
