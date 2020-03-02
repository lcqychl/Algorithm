package leetCode.test1_400.test0201_0220;

/**
 * @author nimingxiong
 * Created at 2020/3/2 19:34
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

public class Test0204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        boolean[] nums = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (nums[j])
                        continue;
                    count++;
                    nums[j] = true;
                }
            }
        }
        return n - count - 2;
    }
}
