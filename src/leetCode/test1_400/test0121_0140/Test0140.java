package leetCode.test1_400.test0121_0140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author nimingxiong
 * @date 2019/12/16 15:23
 *
 * 字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */

public class Test0140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] v = new List[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        return recursive(v, 0, s, set);
    }

    public List<String> recursive(List<String>[] v, int start, String s, HashSet<String> wordDict){
        if(v[start] == null) v[start] = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if(v[i+1] != null && v[i+1].isEmpty()) continue;
            String curStr = s.substring(start, i + 1);
            if (wordDict.contains(curStr)) {
                if(i + 1 != s.length()) {
                    if (v[i + 1] == null)
                        v[i + 1] = recursive(v, i + 1, s, wordDict);
                    for (String temp : v[i + 1]) {
                        v[start].add(curStr + " " + temp);
                    }
                }
                else v[start].add(curStr);
            }
        }
        return v[start];
    }
}
