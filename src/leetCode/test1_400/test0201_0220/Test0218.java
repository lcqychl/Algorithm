package leetCode.test1_400.test0201_0220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nimingxiong
 * Created at 2020/3/17 20:23
 *
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。
 * 可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。
 * 您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。
 * 关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。
 * 此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 * 说明:
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按左 x 坐标 Li  进行升序排列。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
 * 三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 */

public class Test0218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        if (n == 0) return output;
        if (n == 1) {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];
            output.add(new ArrayList<Integer>() {{
                add(xStart);
                add(y);
            }});
            output.add(new ArrayList<Integer>() {{
                add(xEnd);
                add(0);
            }});
            return output;
        }

        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            } else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            maxY = Math.max(leftY, rightY);
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        appendSkyline(output, left, pL, nL, currY);
        appendSkyline(output, right, pR, nR, currY);
        return output;
    }

    public void updateOutput(List<List<Integer>> output, int x, int y) {
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
            output.add(new ArrayList<Integer>() {{
                add(x);
                add(y);
            }});
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                              int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;

            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }
}
