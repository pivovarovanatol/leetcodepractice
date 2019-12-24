package com.leetcode.algors.BalancedBinaryTree;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution {
    public boolean isBalanced(TreeNode root) {
        
    	return isBalancedHelper(root);
    }
    
    boolean isBalancedHelper(TreeNode root) {
    	
    	if (root==null) {
    		return true;
    	}
    	
    	int height = getHeight(root);
    	
    	//System.out.println("Left height: " + heightLeft + ", Right height: " + heightRight);
    	if (height==-1) {
    		return false;
    	} 
    	return true;

    }

    int getHeight(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

    	int left = 0;
    	int right = 0;
    	if (root.left!=null) {
    		left = getHeight(root.left);
    	}
    	
    	if (left == -1) {
    		return -1;
    	}
    	
    	if (root.right!=null) {
    		right = getHeight(root.right);
    	}
    	
    	if (right==-1) {
    		return -1;
    	}
    	
    	int diff = Math.abs(left-right);
    	
    	if (diff > 1) {
    		return -1;
    	}
    	
    	return (1 + (left>right ? left : right));
    }
    
}