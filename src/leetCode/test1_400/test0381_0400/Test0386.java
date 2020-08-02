package leetCode.test1_400.test0381_0400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nimingxiong
 * Created at 2020/8/2 21:10
 *
 * 例如，
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */

public class Test0386 {
    List<Integer> anslexicalOrder = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        lexicalOrderDFS(n, 0, 0);
        return anslexicalOrder;
    }

    public void lexicalOrderDFS(int maxValue, int num, int start) {
        if (num > maxValue)
            return;

        if (num > 0)
            anslexicalOrder.add(num);

        for (int i = start > 0 ? 0 : 1; i <= 9; i++)
            lexicalOrderDFS(maxValue, num * 10 + i, start + 1);
    }
}
