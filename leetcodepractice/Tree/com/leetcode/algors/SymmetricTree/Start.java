package com.leetcode.algors.SymmetricTree;
// https://leetcode.com/problems/symmetric-tree/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,2,3};

		Solution sl = new Solution();
		TreeNode root1 = new TreeNode(arr1[0]);
		root1 = createTree(root1, arr1, 0);

		inOrder(root1);
		System.out.println();
		
		System.out.println(sl.isSymmetric(root1));
		System.out.print(" ");
	}
	
    // Function to create tree from array
	static TreeNode createTree(TreeNode root, int[] arr, int index) {
		
		if (index < arr.length) {
			TreeNode tmp = null;
			if (arr[index]>=0) {
				tmp = new TreeNode(arr[index]);
			}
			else {
				tmp = null;
			}
			root= tmp;
			
			if (root != null) {
				root.left = createTree(tmp.left,arr,index*2+1);
				root.right = createTree(tmp.right,arr,index*2+2);
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

