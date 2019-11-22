package com.leetcode.algors.SymmetricTree;
// https://leetcode.com/problems/symmetric-tree/


class Solution {
    public boolean isSymmetric(TreeNode root) {
//        boolean result=true;
//    	
//        if (root == null) {
//        	return result;
//        }
//        // print in-order into array
//        String str = printInOrder(root);
//        System.out.println(str);
//        
//        // check if this is pallindromic
//        String[] arr = str.split(" ");
//        int n= arr.length;
//        for (int i=0;i<n/2;i++) {
//        	if (!arr[i].equals(arr[n-i-1])) {
//        		result = false;
//        		break;
//        	}
//        }
    	
        return isMirror(root,root);
    }
    
    String printInOrder(TreeNode root) {
    	if (root!=null) {
    		return printInOrder(root.left) + root.val + " " + printInOrder(root.right);
    	} 
    	return "";
    }
    
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
    	if (node1==null && node2==null) {
    		return true;
    	}
    	
    	if ((node1 == null && node2 != null) || (node1 != null && node2==null)) {
    		return false;
    	}
    	
    	if (node1.val != node2.val) {
    		return false;
    	}
    	
    	return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }
    
    
}