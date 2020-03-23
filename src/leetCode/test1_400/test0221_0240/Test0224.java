package leetCode.test1_400.test0221_0240;

import java.util.Stack;

/**
 * @author nimingxiong
 * Created at 2020/3/23 22:20
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格。
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */

public class Test0224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;

            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;

            } else if (ch == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
