package leetCode.test1_400.test0261_0280;

/**
 * @author nimingxiong
 * Created at 2020/5/10 20:54
 */

public class Test0275 {
    public int hIndex(int[] citations) {
        int idx = 0, n = citations.length;
        for (int c : citations) {
            if (c >= n - idx) return n - idx;
            else idx++;
        }
        return 0;
    }
}
