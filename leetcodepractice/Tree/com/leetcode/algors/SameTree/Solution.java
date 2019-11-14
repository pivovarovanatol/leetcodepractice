package com.leetcode.algors.SameTree;
// https://leetcode.com/problems/same-tree/


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
    	String s1 = treeToString(p,"");
    	String s2 = treeToString(q,"");
    	
    	System.out.println(s1);
    	System.out.println(s2);
    	
    	return s1.equals(s2);
    }
    
    public String treeToString(TreeNode root, String s) {
    	
    	if (root == null) {
    		return s;
    	}
    	
    	if (root.left==null) {
        	return s + null + " " + root.val + " "   + treeToString(root.right,s) + " ";
    	}

    	if (root.right==null) {
        	return s + treeToString(root.left,s) + root.val + " " + null;
    	}
    	
    	return s + treeToString(root.left,s) + root.val + " "   + treeToString(root.right,s);
    	
    }
}