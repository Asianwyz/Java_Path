package Lettcode.PrimaryAlgorithms.Tree;

import java.util.*;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class num04 {
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
        List<List<Integer>> list = levelPrint(root);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println(" ");
        }
    }

    private static List<List<Integer>> levelPrint(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (tree.size() > 0){
            List<Integer> level = new ArrayList<>();
            int numberOfLevel = tree.size();
            for (int i = 0; i < numberOfLevel; i++) {
                TreeNode treeNode = tree.poll();
                level.add(treeNode.val);
                if (treeNode.left != null)
                    tree.add(treeNode.left);
                if (treeNode.right != null)
                    tree.add(treeNode.right);
            }
            list.add(level);
        }
        return list;
    }

}
