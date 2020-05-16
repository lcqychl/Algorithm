package leetCode.test1_400.test0301_0320;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nimingxiong
 * Created at 2020/5/16 18:06
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class Test0318 {
    public int bitNumber(char ch) {
        return (int) ch - (int) 'a';
    }

    public int maxProduct(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0, bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }

            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int maxProd = 0;
        for (int x : hashmap.keySet())
            for (int y : hashmap.keySet())
                if ((x & y) == 0) maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));

        return maxProd;
    }
}
