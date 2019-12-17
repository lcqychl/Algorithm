package leetCode.test1_400.test0101_0120;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class Test0113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.target = sum;
        helper(root, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode node, int currentSum, List<Integer> currentList) {

        if (node == null) {
            return;
        }
        currentSum += node.val;
        currentList.add(node.val);
        if (node.left == null && node.right == null) {
            if (currentSum == target) {
                result.add(new ArrayList<Integer>(currentList));
            }
            currentList.remove(currentList.size() - 1);
            return;
        }
        helper(node.left, currentSum, currentList);
        helper(node.right, currentSum, currentList);
        currentList.remove(currentList.size() - 1);
    }
}
