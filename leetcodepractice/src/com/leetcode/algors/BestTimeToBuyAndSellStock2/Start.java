package com.leetcode.algors.BestTimeToBuyAndSellStock2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//-1 represents null values
		//int[] arr = {7,1,5,3,6,4}; // 7
		//int[] arr = {1,2,3,4,5}; // 4
		//int[] arr = {7,6,4,3,1}; // 0
		int[] arr = {2,1,2,0,1}; // 2

		
		
		Solution sl = new Solution();

		int result = sl.maxProfit(arr);
		
		System.out.println(result);
		
	}
	
    // Function to insert nodes in level order 
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) 
    { 
        // Base case for recursion 
        if (i < arr.length) {
        	TreeNode temp = null;
        	
        	if (arr[i]!=-999) {
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
            System.out.print(null + " "); 
        }
    }
    
    public static void printByLevel(TreeNode root) {
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if (root == null) {
    		System.out.print(" null ");
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

