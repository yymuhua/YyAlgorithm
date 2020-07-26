package com.learn.algorithm.tree;

import com.learn.algorithm.TreeNode;

import java.util.*;

/**
 * 二叉树序列化与反序列化
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 10:32 下午
 */
public class CodecTree {
    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder("");
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode thisNode = q.remove();
                if (thisNode == null) {
                    sb.append("N");
                } else {
                    sb.append(thisNode.val);
                    q.add(thisNode.left);
                    q.add(thisNode.right);
                }
                if(i < size - 1) {
                    sb.append(",");
                }
            }
            if(!q.isEmpty()) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /**
     * Decodes your encoded data to tree.
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("N")) {
            return null;
        }
        String[] levels = data.split(";");
        TreeNode root = new TreeNode(Integer.parseInt(levels[0]));
        Queue<TreeNode> upLevels = new LinkedList<>();
        upLevels.add(root);
        for(int i = 1; i < levels.length; i++){
            String[] nodes = levels[i].split(",");
            int size = upLevels.size();
            for(int j = 0; j < size; j++){
                TreeNode father = upLevels.remove();
                if(nodes[2 * j].equals("N")) {
                    father.left = null;
                }
                else {
                    father.left = new TreeNode(Integer.parseInt(nodes[2 * j]));
                    upLevels.add(father.left);
                }
                if(nodes[2 * j + 1].equals("N")) {
                    father.right = null;
                }
                else {
                    father.right = new TreeNode(Integer.parseInt(nodes[2 * j + 1]));
                    upLevels.add(father.right);
                }
            }
        }
        return root;
    }
}
