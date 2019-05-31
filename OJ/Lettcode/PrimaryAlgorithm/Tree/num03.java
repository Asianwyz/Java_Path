package Lettcode.PrimaryAlgorithms.Tree;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

public class num03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(0);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        boolean ans = isSymmetric(root);
        System.out.println(ans);
    }

    private static boolean isSymmetric(TreeNode root) {
        return isEqual(root.left,root.right);
    }

    private static boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isEqual(left.left,right.right) && isEqual(left.right,right.left);
    }
}
