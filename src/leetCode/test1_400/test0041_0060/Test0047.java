package leetCode.test1_400.test0041_0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test0047 {
    List<List<Integer>> ans;
    Stack<Integer> stack;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }
        //先排序哦
        Arrays.sort(nums);
        ans = new ArrayList<>();
        stack = new Stack<>();
        used = new boolean[nums.length];
        process(nums);
        return ans;
    }


    public void process(int[] nums) {
        if(stack.size() == nums.length){
            ans.add(new ArrayList<>(stack));
        }

        for(int i = 0; i < nums.length; i++){
            //从num[1]开始，
            //若某一个元素和上一个元素相等,并且上一个元素没有被使用过，说明它俩在同一层;
            //若某一个元素和上一个元素相等,并且上一个元素被使用过，说明这个元素在上一个元素的子树中
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }


            if(used[i] != true){
                used[i] = true;
                stack.push(nums[i]);
                process(nums);
                used[i] = false;
                stack.pop();
            }
        }
    }
}
