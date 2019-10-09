package leetCode.test1_400.Test0081_0100;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例:
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */

import java.util.Stack;

public class Test0085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length + 1]; //小技巧后边讲
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<Integer>();
            heights[matrix[0].length] = 0;
            //每求一个高度就进行栈的操作
            for (int col = 0; col <= matrix[0].length; col++) {
                if (col < matrix[0].length) { //多申请了 1 个元素，所以要判断
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                if (stack.isEmpty() || heights[col] >= heights[stack.peek()]) {
                    stack.push(col);
                } else {
                    //每次要判断新的栈顶是否高于当前元素
                    while (!stack.isEmpty() && heights[col] < heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        int RightLessMin = col;
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                    stack.push(col);
                }
            }

        }
        return maxArea;
    }
}
