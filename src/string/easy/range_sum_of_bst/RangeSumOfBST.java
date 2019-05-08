package string.easy.range_sum_of_bst;


import org.junit.Test;

import javax.swing.tree.TreeNode;

/**
 * @author zlb
 * @description: 938: https://leetcode.com/problems/range-sum-of-bst/
 * @date 2019/5/6 21:27
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RangeSumOfBST {

    /**
     * @Description: 这个方法是可以的，不过在IDE里，root.val会报错，故注释掉
     * @author zlb
     * @date 2019/5/8 22:05
     */
    /*public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return ((L <= root.val && root.val <= R) ? root.val : 0) +
                rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }*/

    /**
     * @Description: TODO 这个方法也可以，虽然我还不理解
     * @author zlb
     * @date 2019/5/8 22:03
     */
    /*public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        return ((root.val >= L && root.val <= R) ? root.val : 0)
                + ((root.val >= L) ? rangeSumBST(root.left, L, R) : 0)
                + ((root.val <= R) ? rangeSumBST(root.right, L, R) : 0);
        // + ((root.val < R) ? rangeSumBST(root.right, L, R) : 0)
        // + ((root.val > L) ? rangeSumBST(root.left, L, R) : 0);
    }*/



}

