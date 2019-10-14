package leetCode.test1_400.Test0081_0100;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0090 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1 << num.length;
        for (int i = 0; i < subsetNum; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false;
            for (int j = 0; j < num.length; j++) {
                //当前位是 1
                if ((i >> j & 1) == 1) {
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if (j > 0 && num[j] == num[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    } else {
                        list.add(num[j]);
                    }
                }
            }
            if (!illegal) {
                lists.add(list);
            }

        }
        return lists;
    }
}
