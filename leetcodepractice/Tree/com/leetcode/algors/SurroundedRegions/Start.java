package com.leetcode.algors.SurroundedRegions;
// https://leetcode.com/problems/symmetric-tree/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		char[][] board =   {{'X','X','X','X','X','X'},
							{'X','O','O','O','O','X'},
							{'X','X','O','X','O','X'},
							{'X','X','X','O','X','X'},
							{'X','X','O','X','O','X'},
							{'X','X','X','X','X','X'}}; */

		char[][] board =   {{'X','X','X','X'},
							{'X','O','X','X'},
							{'X','O','X','X'},
							{'X','X','X','X'}}; 

		Solution sl = new Solution();
		
		sl.solve(board);
		
		for (int i=0;i<board.length;i++) {
			for (char ch : board[i]) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
		
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

