package leetCode.test1_400.test0301_0320;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author nimingxiong
 * Created at 2020/5/15 20:41
 * 
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1:
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class Test0316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> last_occurrence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}
