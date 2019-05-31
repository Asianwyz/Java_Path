package Lettcode.PrimaryAlgorithms.Tree;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

public class num02 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
//        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2147483647);
//        root.left = left;
        root.right = right;
        System.out.println(isValidBST(root));
//        left.left = new TreeNode(0);
//        left.right = new TreeNode(2);
        right.left = new TreeNode(4);
        right.right = new TreeNode(6);
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isleftBST(root.left,(long) root.val,Long.MIN_VALUE) && isrightBST(root.right,root.val,Long.MAX_VALUE);
    }

    private static boolean isleftBST(TreeNode left, Long father, Long max) {
        if (left == null)
            return true;
        if (left.val >= father || left.val <= max)
            return false;
        return isleftBST(left.left,(long) left.val,max) && isrightBST(left.right,left.val,father);
    }

    private static boolean isrightBST(TreeNode right, long father, long min) {
        if (right == null){
            return true;
        }
        if (right.val <= father || right.val >= min)
            return false;
        return isleftBST(right.left,(long) right.val,father) && isrightBST(right.right,right.val,min);
    }


    /**
     * 缓慢解法
     */
//    private static boolean isValidBST(TreeNode root) {
//        if (root == null)
//            return true;
//        if (root.left != null){
//            int leftMax = maxTreeNumber(root.left);
//            if (leftMax > root.val)
//                return false;
//        }
//        if (root.right != null){
//            int rightmin = minTreeNumber(root.right);
//            if (rightmin < root.val)
//                return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }
//
//    private static int minTreeNumber(TreeNode right) {
//        int min = right.val;
//        if (right.left != null){
//            int num = minTreeNumber(right.left);
//            min = min > num ? num : min;
//        }
//        if (right.right != null){
//            int num = minTreeNumber(right.right);
//            min = min > num ? num : min;
//        }
//        return min;
//    }
//
//    private static int maxTreeNumber(TreeNode left) {
//        int max = left.val;
//        if (left.left != null){
//            int num = maxTreeNumber(left.left);
//            max = max < num ? num : max;
//        }
//        if (left.right != null){
//            int num = maxTreeNumber(left.right);
//            max = max < num ? num : max;
//        }
//        return max;
//    }


}
