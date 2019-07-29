package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class Test0003 {
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (list.indexOf(c) >= 0) {
                list.remove(0);
            }
            list.add(c);
            count = list.size() > count ? list.size() : count;
        }
        return count;
    }
}
