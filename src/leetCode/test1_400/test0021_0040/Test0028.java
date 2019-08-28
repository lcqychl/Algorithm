package leetCode.test1_400.test0021_0040;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class Test0028 {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        int j = 0;
        int fir = -1;
        boolean f = false;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) {
                    fir = i;
                    f = true;
                }
                j++;
                if (j >= needle.length())
                    break;
            } else {
                j = 0;
                if (f) {
                    i = fir;
                    f = false;
                }
            }
        }
        if (j < needle.length())
            fir = -1;
        return fir;
    }
}
