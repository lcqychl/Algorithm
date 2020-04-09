package leetCode.test1_400.test0221_0240;

/**
 * @author nimingxiong
 * Created at 2020/4/9 16:43
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class Test0239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[0];
        }
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i = i + k) {
            left[i] = nums[i];
            int index = i + k - 1 >= len ? len - 1 : i + k - 1;
            right[index] = nums[index];
            for (int j = i + 1; j <= index; j++) {
                left[j] = Math.max(left[j - 1], nums[j]);
            }
            for (int j = index - 1; j >= i; j--) {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] arr = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            arr[i] = Math.max(right[i], left[i + k - 1]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] req = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        int[] resp=maxSlidingWindow(req,k);
        for (int i:resp){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
