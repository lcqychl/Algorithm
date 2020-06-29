package leetCode.test1_400.test0361_0380;

/**
 * @author nimingxiong
 * Created at 2020/6/29 19:49
 *
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 示例 1:
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 */
public class Test0372 {
    public int superPow(int a, int[] b) {
        int numB = b[0];
        a = a % 1337;
        if (a == 0) {
            return 0;
        }
        for (int i = 1; i < b.length; i++) {
            numB = (numB * 10 + b[i]) % 1140;
            //numB*=10;
        }
        numB += 1140;
        int x = a;
        for (int j = 0; j < numB; j++) {
            x = x % 1337;
            x *= a;
        }
        x /= a;
        return x;
    }
}
