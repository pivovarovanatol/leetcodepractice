package com.leetcode.algors.NaryTreePostOrderTraversal;
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.List;

/**
 * Definition for a binary tree node.
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

