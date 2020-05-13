package leetCode.test1_400.test0301_0320;

/**
 * @author nimingxiong
 * Created at 2020/5/13 20:40
 *
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * 示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 */
public class Test0313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int dp[] = new int[n];
        dp[0] = 1;

        int index[] = new int[len];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (min > primes[j] * dp[index[j]]) {
                    min = primes[j] * dp[index[j]];
                }
            }
            dp[i] = min;

            for (int j = 0; j < len; j++) {
                if (min == primes[j] * dp[index[j]]) {
                    index[j]++;
                }
            }

        }
        return dp[n - 1];
    }

}
