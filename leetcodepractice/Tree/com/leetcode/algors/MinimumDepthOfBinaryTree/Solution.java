package com.leetcode.algors.MinimumDepthOfBinaryTree;
// https://leetcode.com/problems/minimum-depth-of-binary-tree/


class Solution {
    public int minDepth(TreeNode root) {
    	
    	if (root==null) {
    		return 0;
    	}
    	
    	if (root.left==null && root.right == null) {
    		return 1;
    	}
    	
        int left=99999;
        int right=99999;
    	if (root.left!=null) {
    		left = minDepth(root.left);
    	}
    	
    	if (root.right!=null) {
    		right = minDepth(root.right);
    	}

    	return 1 + Math.min(left,right);
    }
}