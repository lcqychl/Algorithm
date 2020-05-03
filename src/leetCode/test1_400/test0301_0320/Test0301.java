package leetCode.test1_400.test0301_0320;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nimingxiong
 * Created at 2020/5/3 20:19
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * 示例 1:
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 * 输入: ")("
 * 输出: [""]
 */

public class Test0301 {
    private Set<String> validExpressions = new HashSet<String>();
    private int minimumRemoved;

    private void reset() {
        this.validExpressions.clear();
        this.minimumRemoved = Integer.MAX_VALUE;
    }

    private void recurse(
            String s,
            int index,
            int leftCount,
            int rightCount,
            StringBuilder expression,
            int removedCount) {

        if (index == s.length()) {
            if (leftCount == rightCount) {
                if (removedCount <= this.minimumRemoved) {
                    String possibleAnswer = expression.toString();
                    if (removedCount < this.minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        } else {
            char currentCharacter = s.charAt(index);
            int length = expression.length();
            if (currentCharacter != '(' && currentCharacter != ')') {
                expression.append(currentCharacter);
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);

                if (currentCharacter == '(') {
                    this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }

                expression.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        this.reset();
        this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }
}
