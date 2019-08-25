package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */

public class Test0040 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());

        return ans;
    }

    private void helper(int[] nums, int l, int target, List<Integer> list) {

        if (target == 0) {
            ans.add(new ArrayList<>(list)); //存入的是复制的list对象，避免递归时修改list也修改了ans中的解
            //list = new ArrayList<>();
            return;
        }
        for (int i = l; i < nums.length; i++) {
            //[10,1,2,7,6,1,5] => [1,1,2,5,6,7,10]  target=8
            //假设现在寻找第一个加数，nums[0] = 1 ,第一个加数是位置0的1，然后可以找到 [1,1,6] [1,7]，最后递归回归到i=0，即寻找第一个加数的递归函数
            //尝试nums[1]作为第一个加数, 此时发现nums[1] = nums[0] ,那么递归下去一定可以找到重复的解[1,7], 因此跳过nums[1]
            // i > l的目的是 确保不是第一次使用这个加数，如果不保证i > l, 那么[1,1,6]这样的解就会丢失
            if (i > l && nums[i] == nums[i - 1])
                continue;
            if (target - nums[i] >= 0) {
                list.add(nums[i]);
                helper(nums, i + 1, target - nums[i], list);
                if (list.size() > 0)
                    list.remove(list.size() - 1); //没有找到一组解
            }

        }
    }
}
