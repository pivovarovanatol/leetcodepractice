package com.leetcode.algors.BinaryTreeInorderTraversal;
//https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//-1 represents null values
		// int[] arr1 = {2,3,-1,1,-1};
		// int[] arr1 = {1,-1,2,-1,-1,3,-1,-1,-1};
		 
		
		int[] arr1 = {37,-34,-48,-1,-100,-100,48,-1,-1,-1,-1,-54,-1,-71,-22,-1,-1,-1,8};
		 
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr1[0]);
		root = insertLevelOrder(arr1, root, 0);

		//printByLevel(root);
		System.out.println();
		
		List<Integer> result = sl.inorderTraversal(root);
		
		for (int e : result) {
			System.out.print(e + " ");
		}
	}
	
    // Function to insert nodes in level order 
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) 
    { 
    	
        // Base case for recursion 
        if (i < arr.length) {
        	TreeNode temp = null;
        	
        	if (arr[i]!=-1) {
            	temp = new TreeNode(arr[i]); 
        	} else {
        		return null;
        	}
            root = temp; 
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 
            root.right = insertLevelOrder(arr, root.right,2 * i + 2); 
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

