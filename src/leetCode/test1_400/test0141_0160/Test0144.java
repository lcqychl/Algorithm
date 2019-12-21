package leetCode.test1_400.test0141_0160;

import leetCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nimingxiong
 * @date 2019/12/21 15:41
 *
 *给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]  
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 * 进阶: 通过迭代算法完成
 */
public class Test0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
