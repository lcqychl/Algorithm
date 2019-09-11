package leetCode.test1_400.test0041_0060;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */

public class Test0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<int[]>();
        int i = 0;
        int n = intervals.length;
        int nStart = newInterval[0];
        int nEnd = newInterval[1];
        //当前区间的end 小于 插入区间的 start，跳过并加入结果集
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        //如果到最后都没找到，把newInterval加到最后
        if (i == n) {
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        //选择小的 作为新区的 start
        nStart = Math.min(intervals[i][0], newInterval[0]);
        //如果当前的start < end 把当前end 和  newInterval的end 比较
        while (i < n && intervals[i][0] <= newInterval[1]) {
            nEnd = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(new int[]{nStart, nEnd});

        //如果后面有没遍历到的 加入最后的结果
        while (i < n) {
            res.add(intervals[i++]);
        }
        for (int[] x : res) {
            System.out.println(x[0] + "------" + x[1]);
        }
        return res.toArray(new int[0][]);
    }
}
