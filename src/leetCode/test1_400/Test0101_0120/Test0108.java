package leetCode.test1_400.Test0101_0120;

public class Test0108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length <= 0)
            return null;
        return sortedArrayToBSTCore(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBSTCore(int[] nums,int start ,int end) {
        if(start > end)
            return null;
        int min = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[min]);
        root.left = sortedArrayToBSTCore(nums,start,min-1);
        root.right = sortedArrayToBSTCore(nums,min+1,end);
        return root;
    }
}
