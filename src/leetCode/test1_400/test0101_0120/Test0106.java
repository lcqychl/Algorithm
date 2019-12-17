package leetCode.test1_400.test0101_0120;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

public class Test0106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int post;
    int in;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return buildTreeHelper(inorder, postorder, (long) Integer.MIN_VALUE - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, long stop) {
        if (post == -1) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int root_val = postorder[post--];
        TreeNode root = new TreeNode(root_val);
        root.right = buildTreeHelper(inorder, postorder, root_val);
        root.left = buildTreeHelper(inorder, postorder, stop);
        return root;
    }
}
