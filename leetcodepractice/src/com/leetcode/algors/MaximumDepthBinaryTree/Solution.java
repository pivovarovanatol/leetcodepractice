package com.leetcode.algors.MaximumDepthBinaryTree;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/


class Solution {
    public int maxDepth(TreeNode root) {
    	
    	if (root == null) {
    		return 0;
    	}
    	
    	if (root.left == null && root.right == null) {
    		return 1;
    	}
    	int depth1 = 1;
    	int depth2 = 1;
    	
    	if (root.left != null) {
    		depth1 += maxDepth(root.left);
    	}
    	
    	if (root.right != null) {
    		depth2 += maxDepth(root.right);
    	}
    	
    	if (depth1 > depth2) {
    		return depth1;
    	} else {
    		return depth2;
    	}
    }
    
    
    
}