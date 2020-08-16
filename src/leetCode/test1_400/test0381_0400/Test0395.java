package leetCode.test1_400.test0381_0400;

/**
 * @author nimingxiong
 * Created at 2020/8/16 19:14
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 示例 1:
 * 输入:
 * s = "aaabb", k = 3
 * 输出:
 * 3
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * 输入:
 * s = "ababbc", k = 2
 * 输出:
 * 5
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */

public class Test0395 {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;

        return count(s.toCharArray(), k, 0, len - 1);
    }

    private static int count(char[] chars, int k, int p1, int p2) {
        if (p2 - p1 + 1 < k) return 0;
        int[] times = new int[26];
        for (int i = p1; i <= p2; ++i) {
            ++times[chars[i] - 'a'];
        }
        while (p2 - p1 + 1 >= k && times[chars[p1] - 'a'] < k) {
            ++p1;
        }
        while (p2 - p1 + 1 >= k && times[chars[p2] - 'a'] < k) {
            --p2;
        }

        if (p2 - p1 + 1 < k) return 0;
        for (int i = p1; i <= p2; ++i) {
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
            }
        }
        return p2 - p1 + 1;
    }
}
