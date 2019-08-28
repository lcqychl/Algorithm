package leetCode.test1_400.test0041_0060;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Test0042 {
    public int trap(int[] height) {
        int n = height.length, sum = 0;
        if(n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        /*思路：动态规划求解
         * 计算出每一列中左边最高， 右边最高的高度
         * 最后每一列中包含水滴的个数即为两边最低的高度减去当前高度
         */
        for(int i = 1; i < n; i ++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        for(int i = n-2; i >= 0; i --) {
            right[i] = Math.max(height[i], right[i+1]);
        }
        //计算每一列中水滴的数量
        for(int i = 0; i < n; i ++) {
            sum += Math.min(left[i], right[i])-height[i];
            System.out.println(Math.min(left[i], right[i])-height[i]);
        }
        return sum;
    }
}
