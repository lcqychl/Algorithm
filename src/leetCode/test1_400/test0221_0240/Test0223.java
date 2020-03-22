package leetCode.test1_400.test0221_0240;

/**
 * @author nimingxiong
 * Created at 2020/3/22 16:52
 *
 *在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。、
 * 示例:、
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45、
 */

public class Test0223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A;
        int width1 = D - B;
        int area1 = length1 * width1;

        int length2 = G - E;
        int width2 = H - F;
        int area2 = length2 * width2;

        if (E >= C || G <= A || F >= D || H <= B) {
            return area1 + area2;
        }

        int x1 = Math.min(C, G);
        int x2 = Math.max(E, A);
        int length3 = x1 - x2;

        int y1 = Math.min(D, H);
        int y2 = Math.max(F, B);
        int width3 = y1 - y2;
        int area3 = length3 * width3;

        return area1 + area2 - area3;
    }
}
