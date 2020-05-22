package leetCode.test1_400.test0321_0340;

import java.util.TreeMap;

/**
 * @author nimingxiong
 * Created at 2020/5/22 19:25
 *
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * 示例:
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 */
public class Test0327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TreeMap<Long, Integer> tree = new TreeMap<>();
        tree.put(0L, 1);

        int count = 0;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
            for (int cnt : tree.subMap(sum - upper, true, sum - lower, true).values()) {
                count += cnt;
            }
            tree.put(sum, tree.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
