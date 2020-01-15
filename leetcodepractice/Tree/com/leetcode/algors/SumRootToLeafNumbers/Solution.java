package com.leetcode.algors.SumRootToLeafNumbers;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
	
	// from discussions. 0ms(<100%) 35.4MB(<100%)
	public int sumNumbers(TreeNode root) {
			List<Integer> res= new ArrayList<>();
			sumtree(root,res,0);
			int num=0;
			
			for (int n : res) {
				num += n;
			}
			
			return num;
		}
	
		public void sumtree(TreeNode root, List<Integer> res,int sum){
			if(root==null) return;
			sum=sum*10+root.val;
			
			if(root.left==null&&root.right==null){
				res.add(sum);
			}
			
			sumtree(root.left,res,sum);
			sumtree(root.right,res,sum);
		}
		
	
	// Solved iteratively. 3ms(<7.5%) 35.3MB(<100%).
    public int sumNumbers1(TreeNode root) {
    	if (root==null){
            return 0;
        }
        int result = 0;
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        st.push(node);
        HashSet<TreeNode> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        
        while (!st.isEmpty()) {
        	if (node.left!=null && !set.contains(node.left)) {
        		st.push(node);
        		list.add(node.val);
        		node = node.left;
        		continue;
        	}

        	if (node.right!=null && !set.contains(node.right)) {
        		st.push(node);
        		list.add(node.val);
        		node = node.right;
        		continue;
        	}
        	
            // leaf node
            if (node.left==null && node.right==null) {
            	int tmp = node.val;
            	int i=list.size();
            	while (i>0) {
            		tmp += list.get(i-1) * Math.pow(10, list.size()-i+1);
            		i--;
            	}
            	result+=tmp;
            }
            if (list.size()>0) {
            	list.remove(list.size()-1);
            }
        	
        	set.add(node);
        	node = st.pop();
        }
        
        return result;
    }
	
	
	
	// solved with DFS. 1ms(<26%) 36MB(<100%)
    public int sumNumbers2(TreeNode root) {
        // Use DFS to go from root to every leaf building he string with number.
        // once the leaf node is reached - convert to number and add to running sum. 
        // return running sum back to the level above.
        if (root==null){
            return 0;
        }
        int result = dfs(root, 0, "");
        return result;
    }
    
    int dfs(TreeNode root, int sum, String str){
        str += Integer.toString(root.val);
        // leaf node
        if (root.left == null && root.right==null){
            sum += Integer.parseInt(str);
            return sum;
        } else {
            int leftSum = 0;
            int rightSum = 0;
            if (root.left!=null){
                leftSum = dfs(root.left, sum, str);    
            }
            if (root.right!=null){
                rightSum = dfs(root.right, sum, str);    
            }
            return (sum + leftSum + rightSum);
        }
    }
    
}


