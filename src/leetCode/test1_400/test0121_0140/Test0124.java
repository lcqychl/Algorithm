package leetCode.test1_400.test0121_0140;

/**
 *给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
示例 1:
输入: [1,2,3]

       1
      / \
     2   3
输出: 6
示例 2:
输入: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 * */

public class Test0124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        int price_newpath = node.val + left_gain + right_gain;

        max_sum = Math.max(max_sum, price_newpath);

        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
