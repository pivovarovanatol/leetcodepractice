package com.leetcode.algors.InvertBinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/invert-binary-tree/


class Solution {
	
	//Iterative solution with BFS -> 0ms(<100%) 34.2MB(<100%)
	public TreeNode invertTree(TreeNode root) {
        
	    Deque<TreeNode> q = new ArrayDeque<>();
	        if(root == null){
	            return root;
	        }
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            TreeNode tNode = q.remove();
	            
	            TreeNode temp = tNode.left;
	            tNode.left = tNode.right;
	            tNode.right = temp;
	            
	            if(tNode.left != null)
	            q.add(tNode.left);
	            
	            if(tNode.right != null)
	            q.add(tNode.right);
	        }

	        return root;
	    }	
	
	
	// Solved recursively 0ms(<100%) 34.2MB(<100%)
    public TreeNode invertTree2(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}