package leetCode.test1_400.test0321_0340;

/**
 * @author nimingxiong
 * Created at 2020/5/18 20:10
 *
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */
public class Test0321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        for (int arr1_num_select = Math.max(0, k - len2); arr1_num_select <= len1 && arr1_num_select <= k; arr1_num_select++) {
            int[] arr = mergeMaxArr(maxArr(nums1, arr1_num_select), maxArr(nums2, k - arr1_num_select), k);
            if (compare(arr, res, k))
                res = arr;
        }
        return res;
    }

    private int[] maxArr(int[] num, int pos) {
        int max_len = num.length;
        if (max_len == pos)
            return num;
        int[] res = new int[pos];
        int res_top_index = -1;
        for (int cur_to_In = 0; cur_to_In < max_len; cur_to_In++) {
            while (res_top_index + 1 > 0 && num[cur_to_In] > res[res_top_index] && res_top_index + 1 + max_len - cur_to_In > pos)
                res_top_index--;
            if (res_top_index < pos - 1)
                res[++res_top_index] = num[cur_to_In];
        }
        return res;
    }

    private int[] mergeMaxArr(int[] maxArr1, int[] maxArr2, int pos) {
        int p1 = 0, p2 = 0;
        int[] res = new int[pos];
        int index = 0;
        while (index < pos) {
            if (compare(maxArr1, maxArr2, p1, p2))
                res[index++] = maxArr1[p1++];
            else res[index++] = maxArr2[p2++];
        }
        return res;
    }

    private boolean compare(int[] arr1, int[] arr2, int k) {

        int p = 0;
        while (p < k && arr1[p] == arr2[p])
            p++;
        return p == k || arr1[p] >= arr2[p];
    }

    private boolean compare(int[] arr1, int[] arr2, int p1, int p2) {

        int len1 = arr1.length, len2 = arr2.length;
        while (p1 < len1 && p2 < len2 && arr1[p1] == arr2[p2]) {
            p1++;
            p2++;
        }
        return p2 == len2 || (p1 < len1 && arr1[p1] > arr2[p2]);
    }

}
