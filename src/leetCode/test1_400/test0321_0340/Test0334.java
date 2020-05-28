package leetCode.test1_400.test0321_0340;

/**
 * @author nimingxiong
 * Created at 2020/5/28 19:44
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Test0334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > secondMin) return true;
            if (nums[i] <= firstMin)
                firstMin = nums[i];
            else if (nums[i] < secondMin)
                secondMin = nums[i];
        }
        return false;
    }
}
