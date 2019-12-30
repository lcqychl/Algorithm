package leetCode.test1_400.test0141_0160;

/**
 * @author nimingxiong
 * @date 2019/12/30 16:19
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Test0151 {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] s1 = s.trim().split(" ");
        for(int i = s1.length - 1; i >= 0; i--){
            if(!s1[i].equals("")) ans.append(s1[i] + " ");
        }
        ans = new StringBuilder(ans.toString().trim());
        return ans.toString();
    }

    public static void main(String[] args) {
        String s="I have a pan.";
        System.out.println(reverseWords(s));
    }
}
