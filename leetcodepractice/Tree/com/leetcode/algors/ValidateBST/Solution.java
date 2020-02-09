package com.leetcode.algors.ValidateBST;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/validate-binary-search-tree/


class Solution {
    
    // solved with in-order traversal and iterative check - in 1ms(<36%) 41MB(<5%)
    public boolean isValidBST(TreeNode root) {
        //idea - do an in-order traversal and create an array list then check if array list is in increasing order.
        if (root==null) {return true;}
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        int prev = list.get(0);
        list.remove(0);
        for (int e: list){
            if (e <= prev){
                return false;
            } else {
                prev=e;
            }
        }
        return true;
    }
    
    public void inOrder(TreeNode root, List<Integer> list){
        // base case for recursion
        if (root==null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right,list);
        return;
    }
}
