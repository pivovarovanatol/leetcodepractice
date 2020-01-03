package com.leetcode.algors.LCAofBinarySearchTree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};

		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(arr, root, 0);
		
		TreeNode p = findNodeByValue(root, 2);
		TreeNode q = findNodeByValue(root, 8);
				
		TreeNode lca = sl.lowestCommonAncestor(root, p, q);
		System.out.print(lca.val);
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
	
    public static TreeNode findNodeByValue(TreeNode root, int val) {
    	if (root == null) {
    		return null;
    	}
    	
    	if (root.val == val) {
    		return root;
    	}
    	
    	TreeNode left = findNodeByValue(root.left, val);
    	if (left!=null) return left;
    	
    	TreeNode right = findNodeByValue(root.right, val);
    	if (right!=null) return right;
    	
    	return null;
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
    
}

