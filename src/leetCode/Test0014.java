package leetCode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Test0014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String s = "";
        String tmp;
        for (int i = 0; i <= strs[0].length(); i++) {
            tmp = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(tmp)) return s;
            }
            s = tmp;
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strs = {"c", "c"};
        System.out.println(longestCommonPrefix(strs));
    }
}
