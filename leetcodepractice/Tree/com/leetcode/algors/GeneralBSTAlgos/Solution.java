package com.leetcode.algors.GeneralBSTAlgos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author I855719
 * 
 */

class Solution {
	
	/**
	 * Return the number of unique BST trees generated from 1 to n 
	 * 
	 */
	public int numTrees(int n) {
//		ArrayList<TreeNode> res = createTrees(1, n);
//		for (TreeNode root:res) {
//			inOrder(root);
//			System.out.println();
//		}
//		return res.size();
		HashMap<String, Integer> map = new HashMap<>();
		return countTrees(1,n,map);
	}

	int countTrees(int start, int end, HashMap<String, Integer> map) {
		if (map.containsKey(start+"|"+end)) return map.get(start+"|"+end);
		if (start>end) return 1;
		int count=0;
		
		for (int i=start;i<=end;i++) {
			int leftSubtrees = countTrees(start, i-1, map);
			int rightSubtrees = countTrees(i+1, end, map);
			rightSubtrees = rightSubtrees == 0 ? 1 : rightSubtrees;
			leftSubtrees = leftSubtrees == 0 ? 1 : leftSubtrees;
			count += (leftSubtrees * rightSubtrees);
		}
		map.put(start+"|"+end, count);
		return count;
	}

	
	
	ArrayList<TreeNode> createTrees(int start, int end) {
		if (start>end) return null;
		ArrayList<TreeNode> res = new ArrayList<>();
		
		for (int i=start;i<=end;i++) {
			ArrayList<TreeNode> leftSubtrees = createTrees(start, i-1);
			ArrayList<TreeNode> rightSubtrees = createTrees(i+1, end);
			if (leftSubtrees != null) {
				for (TreeNode left : leftSubtrees) {
					if (rightSubtrees!=null) {
						for (TreeNode right : rightSubtrees) {
							TreeNode node = new TreeNode();
							node.val = i;
							node.left = left;
							node.right = right;
							res.add(node);
						}
					} else {
						TreeNode node = new TreeNode();
						node.val = i;
						node.left = left;
						node.right = null;
						res.add(node);
					}
				}
			} else {
				if (rightSubtrees!=null) {
					for (TreeNode right : rightSubtrees) {
						TreeNode node = new TreeNode();
						node.val = i;
						node.left = null;
						node.right = right;
						res.add(node);
					}
				} else {
					TreeNode node = new TreeNode();
					node.val = i;
					node.left = null;
					node.right = null;
					res.add(node);
				}
			}
		}
		
		return res;
	}

	void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.val  + " ");
		inOrder(root.right);
		return;
	}

	/**
	 * Calculates the number of unique BSTs from 1 to n using Catalan numbers
	 */
    public int numTreesK(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        
        for (int i=1; i<=n; i++) { 
            for (int j=0; j<i; j++) 
              dp[i]+=dp[j]*dp[i-1-j];
          } 

        return dp[n];
    }
	
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}	
	
	
	
}