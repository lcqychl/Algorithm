package leetCode.test1_400.test0201_0220;

/**
 * @author nimingxiong
 * Created at 2020/3/13 19:59
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 */
public class Test0214 {
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public String shortestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        //这里的话需要修改
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            int start = (i - P[i]) / 2;
            //我们要判断当前回文串是不是开头是不是从 0 开始的
            if (start == 0) {
                maxLen = P[i] > maxLen ? P[i] : maxLen;
            }
        }
        return new StringBuilder(s.substring(maxLen)).reverse() + s;
    }
}
