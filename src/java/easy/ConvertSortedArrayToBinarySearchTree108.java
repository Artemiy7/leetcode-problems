package easy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return populateBST(nums, 0, nums.length - 1);
    }

    public TreeNode populateBST(int [] nums, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = populateBST(nums, start, mid - 1);
        treeNode.right = populateBST(nums, mid + 1, end);

        return treeNode;
    }
}
