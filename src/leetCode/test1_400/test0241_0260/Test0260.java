package leetCode.test1_400.test0241_0260;

/**
 * @author nimingxiong
 * Created at 2020/4/15 23:38
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 */

public class Test0260 {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) if ((num & diff) != 0) x ^= num;
        return new int[]{x, bitmask ^ x};
    }
}
