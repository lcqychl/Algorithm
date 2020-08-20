package leetCode.test1_400.test0381_0400;


/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 231)。
 * 示例 1:
 * 输入:
 * 3
 * 输出:
 * 3
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */

public class Test0400 {

    public int findNthDigit(int n) {
        if (n <= 9) return n;
        long base = 1; //由于输入是int所以n不爆，但是base*10是可能爆的
        int digit = 1;
        n--;  //是因为n>=10的时候前面是一共0-9有10个数，10对应于base第0个数的第0位，如果不减接下去循环就变成base的第0个数第1位
        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }
        return String.valueOf(base + n / digit).charAt(n % digit) - '0';
    }

}
