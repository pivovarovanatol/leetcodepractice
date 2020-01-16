package com.leetcode.algors.BinaryTreeLevelOrderTraversal;
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
	
	// From discussions. Solved with DFS. 0ms(<100%) 42.8MB(<5%)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer> > list = new ArrayList<List<Integer> > ();
        
        levelOrderDfsRec(root, 0, list);
        
        return list;
    }
    
    
    public void levelOrderDfsRec(TreeNode root, int i, List<List<Integer>> levels){
            if(root == null)
                return;
            if(levels.size() <= i)
                levels.add(new LinkedList<Integer>());
            List<Integer> myLevel = levels.get(i);
            myLevel.add(root.val);
            levelOrderDfsRec(root.left, i+1, levels);
            levelOrderDfsRec(root.right, i+1, levels);
    }
    
	
    // solved with BFS. 1ms(<75%) 42.9MB(<6%)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        List<Integer> level = new ArrayList<>();
        queue1.add(root);
        
        while(!queue1.isEmpty()){
            TreeNode node = queue1.remove();
            if (node.left!=null){
                queue2.add(node.left);
            }
            if (node.right!=null){
                queue2.add(node.right);
            }
            level.add(node.val);
            if (queue1.isEmpty()) {
                list.add(level);
                level = new ArrayList<>();
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
            }
        }
            return list;
    }
}

