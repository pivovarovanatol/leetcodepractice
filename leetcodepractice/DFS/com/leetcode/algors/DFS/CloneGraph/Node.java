package com.leetcode.algors.DFS.CloneGraph;
//https://leetcode.com/problems/clone-graph/

import java.util.List;

//Definition for a Node.
class Node {
public int val;
public List<Node> neighbors;

public Node() {}

public Node(int _val,List<Node> _neighbors) {
   val = _val;
   neighbors = _neighbors;
}
};

