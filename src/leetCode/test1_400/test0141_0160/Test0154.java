package leetCode.test1_400.test0141_0160;

/**
 * @author nimingxiong
 * @date 2020/1/3 18:47
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class Test0154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }
}
