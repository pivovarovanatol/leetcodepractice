package com.leetcode.algors.BinaryTreeInorderTraversal;
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	// Solved iteratively. 1ms (<35%) 35.5MB(<100%)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        if (root==null){
            return result;
        }
        
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        st.push(root);
        node=root;
        
        while (!st.isEmpty()){
        	if (node.left!=null) {
        		st.push(node.left);
        		node = node.left;
        		continue;
        	} 
        	
        	node = st.pop();
        	if (!set.contains(node)) {
        		result.add(node.val);
        		set.add(node);
        	}
        	
        	if (node.right!=null) {
        		st.push(node.right);
        		node = node.right;
        	}
        }
        return result;
    }

    

	// First trivial solution with DFS. 0ms(<100%) 35.4MB(<100%)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    public void dfs(TreeNode root, List<Integer> result){
        if (root==null){
            return;
        } else {
           if (root.left!=null){
                dfs(root.left, result);   
           }
           result.add(root.val);
           if (root.right!=null){
                dfs(root.right, result);   
           }
        }
        return;
    }
    
    
}

