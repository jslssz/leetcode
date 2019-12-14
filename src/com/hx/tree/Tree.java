package com.hx.tree;

import com.hx.list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jxlgcmh
 * @date 2019-11-15 09:33
 * @description
 */
public class Tree {
    public static void main(String[] args) {
        // 初始化一个二叉树
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode rl = new TreeNode(3);
        root.left = l1;
        root.right = rl;
        TreeNode ll2 = new TreeNode(4);
        TreeNode lr2 = new TreeNode(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNode rl2 = new TreeNode(6);
        TreeNode rr2 = new TreeNode(7);
        rl.left = rl2;
        rl.right = rr2;
        // 测试工作
        Tree instance = new Tree();
//        instance.levelOrderBottom(root);
        int [] arr ={-10,-3,0,5,9};
        instance.sortedArrayToBST(arr);
    }

    public void build(){
        TreeNode root = new TreeNode(10);
        for (int i = 1; i <=10 ; i++) {
            root.right=new TreeNode(root.val*2);
            root.left=new TreeNode(root.val -i);
        }
    }





    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * @param nums 给定有序数组: [-10,-3,0,5,9],
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }


    /**
     * 层序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // queue是临时队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 通过size，总计出多少次队列
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 合并二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode resultNode = new TreeNode(t1.val + t2.val);
        resultNode.left = mergeTrees(t1.left, t2.left);
        resultNode.right = mergeTrees(t1.right, t2.right);
        return resultNode;
    }

    public TreeNode mergeTreesII(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 反转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode rootLeft = invertTree(root.left);
        TreeNode rootRight = invertTree(root.right);
        root.left = rootRight;
        root.right = rootLeft;
        return root;

    }

    /**
     * 求二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
