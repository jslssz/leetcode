package com.hx.tree;

/**
 * @author jxlgcmh
 * @date 2019-11-15 09:33
 * @description
 */
public class Tree {
    public static void main(String[] args) {

    }


    /**
     *  反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode rootLeft =  invertTree(root.left);
        TreeNode rootRight =  invertTree(root.right);
        root.left  =rootRight;
        root.right = rootLeft;
        return root;

    }

    /**
     *  求二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
