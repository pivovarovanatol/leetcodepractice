package com.leetcode.algors.BinaryTreePreorderTraversal;
// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
class Solution {
    List<Integer> list;
    //solved with DFS and iteratively. 0ms(<100%) 41MB(<6%)
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root==null){
            return list;
        }

        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            list.add(node.val);
            if (node.right!=null) st.push(node.right);
            if (node.left!=null) st.push(node.left);
            
        }
        
        return list;        
    }
    
    //solved with DFS and iteratively. 0ms(<100%) 41MB(<6%)
    public List<Integer> preorderTraversal2(TreeNode root) {
        list = new ArrayList<>();
        if (root==null){
            return list;
        }
        
        dfs(root);
        return list;        
    }
    
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    
}