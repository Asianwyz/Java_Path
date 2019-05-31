package Lettcode.PrimaryAlgorithms.Tree;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class num05 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = solution(nums);
        System.out.println(root.val);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(root.left.right.val + " " + root.right.right.val);
    }

    private static TreeNode solution(int[] nums) {
        return bst(nums,0,nums.length - 1);
    }

    private static TreeNode bst(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums,l,mid - 1);
        node.right = bst(nums,mid + 1, r);
        return node;
    }
}
