package com.leetcode.algors.BalancedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//-1 represents null values
		int[] arr1 = {1,2,2,3,3,-1,-1,4,4};

		Solution sl = new Solution();
		TreeNode root1 = new TreeNode(arr1[0]);
		root1 = insertLevelOrder(arr1, root1, 0);

		printByLevel(root1);
		System.out.println(sl.isBalanced(root1));
		
		//System.out.println(sl.sortedArrayToBST(arr1));
		System.out.print(" ");
	}
	
    // Function to insert nodes in level order 
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) 
    { 
        // Base case for recursion 
        if (i < arr.length) {
        	TreeNode temp = null;
        	
        	if (arr[i]>=0) {
            	temp = new TreeNode(arr[i]); 
        	} 
        		
            root = temp; 
            
            if (root != null) {
                // insert left child 
                root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 
      
                // insert right child 
                root.right = insertLevelOrder(arr, root.right,2 * i + 2); 
            }
        } 
        return root; 
    }
	
    
    // Function to print tree nodes in InOrder fashion 
    public static void inOrder(TreeNode root) 
    { 
        if (root != null) { 
            inOrder(root.left); 
            System.out.print(root.val + " "); 
            inOrder(root.right); 
        } else {
            //System.out.print(null + " "); 
        }
    }
    
    public static void printByLevel(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if (root == null) {
    		return;
    	}
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
    		TreeNode tmp = queue.poll();
    		System.out.print(tmp.val+ " ");
    		
    		if (tmp.left !=null) {
    			queue.add(tmp.left);
    		}
    		if (tmp.right !=null) {
    			queue.add(tmp.right);
    		}
    	}
    	
    }
    
    
    
    
    
}

