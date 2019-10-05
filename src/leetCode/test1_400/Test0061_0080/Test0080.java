package leetCode.test1_400.Test0061_0080;

/*
*
* */

public class Test0080 {
    public int removeDuplicates(int[] nums) {
        int m = 0;
        for (int i = 0; i < nums.length;) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                int val = nums[i];
                nums[m++] = nums[i++];
                nums[m++] = nums[i++];
                while (i < nums.length && nums[i] == val)
                    i++;
            } else
                nums[m++] = nums[i++];
        }
        return m;
    }
}
