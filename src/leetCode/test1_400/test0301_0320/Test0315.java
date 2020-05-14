package leetCode.test1_400.test0301_0320;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author nimingxiong
 * Created at 2020/5/14 19:50
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class Test0315 {
    Map<Integer, Integer> res;

    public List<Integer> countSmaller(int[] nums) {
        res = new HashMap<>();
        int[][] numsWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }
        List<Integer> ans = new LinkedList<>();
        mergeSort(numsWithIndex, 0, nums.length - 1);
        for (int n = 0; n < nums.length; n++) {
            ans.add(res.getOrDefault(n, 0));
        }
        return ans;
    }

    private void mergeSort(int[][] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        int i = lo, j = mid + 1, k = 0;
        int[][] cmp = new int[hi - lo + 1][2];
        while (i <= mid) {
            while (j <= hi && nums[j][0] < nums[i][0]) {
                cmp[k++] = nums[j++];
            }
            res.put(nums[i][1], res.getOrDefault(nums[i][1], 0) + j - mid - 1);
            cmp[k++] = nums[i++];
        }
        while (j <= hi) cmp[k++] = nums[j++];
        System.arraycopy(cmp, 0, nums, lo, cmp.length);
    }
}
