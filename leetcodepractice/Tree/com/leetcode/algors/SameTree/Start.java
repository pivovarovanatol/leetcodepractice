package com.leetcode.algors.SameTree;
// https://leetcode.com/problems/same-tree/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,1};
		int[] arr2 = {1,-1,1};

		Solution sl = new Solution();
		TreeNode root1 = new TreeNode(arr1[0]);
		root1 = insertLevelOrder(arr1, root1, 0);

		TreeNode root2 = new TreeNode(arr2[0]);
		root2 = insertLevelOrder(arr2, root2, 0);

		//inOrder(root1);
		//System.out.println();
		
		System.out.println(sl.isSameTree(root1, root2));
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
    
}

