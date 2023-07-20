package easy;

import util.TreeNode;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int actualSum = 0;

        return hasPath(root, actualSum, targetSum);
    }

    public boolean hasPath(TreeNode treeNode, int actualSum, int targetSum) {
        if (treeNode == null)
            return false;

        actualSum = treeNode.val + actualSum;

        if (treeNode.left == null && treeNode.right == null) {
            if (actualSum == targetSum)
                return true;
        }

        return hasPath(treeNode.left, actualSum, targetSum) || hasPath(treeNode.right, actualSum, targetSum);
    }
}
