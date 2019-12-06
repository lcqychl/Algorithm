package leetCode.test1_400.Test0121_0140;

/**
 * @author nimingxiong
 * @date 2019/12/6 19:29
 */

/*
*给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回符合要求的最少分割次数。
示例:
输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
* */

public class Test0132 {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();

        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        minCutHelper(s, 0, dp, 0);
        return min;

    }

    int min = Integer.MAX_VALUE;
    //num 记录已经切割的次数
    private void minCutHelper(String s, int start, boolean[][] dp, int num) {
        if (dp[start][s.length() - 1]) {
            min = Math.min(min, num);
            return;
        }
        //尝试当前字符串所有的切割位置
        for (int i = start; i < s.length() - 1; i++) {
            if (dp[start][i]) {
                minCutHelper(s, i + 1, dp, num + 1);
            }
        }
    }
}
