package leetCode.test1_400.test0161_0180;

/**
 * @author nimingxiong
 * Created at 2020/2/22 19:55
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

public class Test0179 {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (getCustomMaxVal(nums[i], nums[j]) != nums[i]) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
            if (nums[0] == 0)
                return "0";
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private int getCustomMaxVal(int num1, int num2) {
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);
        String a = num1Str + num2Str;
        String b = num2Str + num1Str;
        String result = customCompare(a, b);
        return result.equals(a) ? num1 : num2;
    }

    private String customCompare(String a, String b) {
        int i = 0;
        int len = a.length();
        while (i < len) {
            if (a.charAt(i) > b.charAt(i)) {
                return a;
            } else if (a.charAt(i) < b.charAt(i)) {
                return b;
            } else {
                i++;
            }
        }
        return a;
    }
}
