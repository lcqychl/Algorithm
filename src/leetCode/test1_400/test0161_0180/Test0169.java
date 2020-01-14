package leetCode.test1_400.test0161_0180;

/**
 * @author nimingxiong
 * Created at 2020/1/14 11:15
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Test0169 {
    //计数法
    public int majorityElement(int[] nums) {
        int most = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                most = nums[i];
                count = 1;
            } else if (most == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return most;
    }

    //位运算
    public int majorityElement2(int[] nums) {
        int result = 0, k = nums.length >> 1;
        for (int j = 0; j < 32; j++) {
            int count = 0;
            for (int num : nums) {
                count += num >> j & 1;
                if (count > k) {
                    result += 1 << j;
                    break;
                }
            }
        }
        return result;
    }
}
