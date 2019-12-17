package leetCode.test1_400.test0121_0140;

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
        int[] dp = new int[s.length()];
        int n = s.length();
        //假设没有任何的回文串，初始化 dp
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // 考虑每个中心
        for (int i = 0; i < s.length(); i++) {
            // j 表示某一个方向扩展的个数
            int j = 0;
            // 考虑奇数的情况
            while (true) {
                if (i - j < 0 || i + j > n - 1) {
                    break;
                }
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (i - j == 0) {
                        dp[i + j] = 0;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i - j - 1] + 1);
                    }

                } else {
                    break;
                }
                j++;
            }

            // j 表示某一个方向扩展的个数
            j = 1;
            // 考虑偶数的情况
            while (true) {
                if (i - j + 1 < 0 || i + j > n - 1) {
                    break;
                }
                if (s.charAt(i - j + 1) == s.charAt(i + j)) {
                    if (i - j + 1 == 0) {
                        dp[i + j] = 0;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i - j + 1 - 1] + 1);
                    }

                } else {
                    break;
                }
                j++;
            }

        }
        return dp[n - 1];
    }
}
