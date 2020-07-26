package com.learn.algorithm.tree;

import com.learn.algorithm.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 * 判断B是否为A的子结构
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 8:11 下午
 */
public class SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 可能有多个节点val等于B.val，因此当前节点不符合还需要判断子树是否符合
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 从当前节点开始匹配，判断是否具有相同结构
     * @param A
     * @param B
     * @return
     */
    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
