package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */

public class Test0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> oriMap = new HashMap<>();
        for (String str : words) {
            //这个计数很重要 因为words里可能有相同的单词
            oriMap.put(str, oriMap.getOrDefault(str, 0) + 1);
        }
        int len = words[0].length();
        int totalLen = len * words.length;

        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            windowMap.clear();
            while (right <= s.length() - len && left <= s.length() - totalLen) {
                String str = s.substring(right, right + len);
                if (!oriMap.containsKey(str)) {
                    //单词不在里面 直接从right+len开始找
                    windowMap.clear();
                    right += len;
                    left = right;
                    continue;
                }
                windowMap.put(str, windowMap.getOrDefault(str, 0) + 1);
                while (oriMap.get(str) < windowMap.get(str)) {
                    String rem = s.substring(left, left + len);
                    windowMap.put(rem, windowMap.get(rem) - 1);
                    left += len;
                }
                right += len;
                if (right - left == totalLen) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}
