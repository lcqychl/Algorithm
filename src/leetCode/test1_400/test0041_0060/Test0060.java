package leetCode.test1_400.test0041_0060;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */

public class Test0060 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //阶乘数组
        int[] factorials = new int[n];
        //注意0和1的阶乘为1
        factorials[0] = 1;
        //阶乘值为当前值乘前一个阶乘值
        for (int i = 1; i < n; i++) {
            factorials[i] = i * factorials[i - 1];
        }
        //list存储“数字”，因此remove后依旧有序，无需排序。
        //这保证了我们只要知道需要获取值的偏移量就可以得到对应的值。
        List<Character> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add((char) (i + 48));
        }
        int index;
        //将题目的人类习惯奇数改为list内部下标计数。
        k--;
        //最差情况下从第一位一直运算到第n-1位，最后一位便是剩下的。
        for (int j = 1; j < n; j++) {
            int factorial = factorials[n - j];
            //获取该位“数字”在list内的下标
            index = k / factorial;
            k = k % factorial;
            //将这一位“数字”加进来后从list内部删除该“数字”
            sb.append(nums.get(index));
            nums.remove(index);
            //如果此时不再有相对偏移量，退出循环。
            if (k == 0) {
                break;
            }
        }
        //如果最差情况，此时将最后一位加进来，
        //如果中途因为刚好匹配、没有偏移量而退出则按序将剩余“数字”加进来。
        while (nums.size() > 0) {
            sb.append(nums.get(0));
            nums.remove(0);
        }
        return sb.toString();
    }
}
