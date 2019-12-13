package com.leetcode.algors.DFS.CloneGraph;
// https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();

		node1.val = 1;
		node2.val = 2;
		node3.val = 3;
		node4.val = 4;
		
		List<Node> n1 = new ArrayList<Node>(); 
		n1.add(node2);
		n1.add(node4);
		node1.neighbors = n1;
		
		List<Node> n2 = new ArrayList<Node>(); 
		n2.add(node1);
		n2.add(node3);
		node2.neighbors = n2;
		
		List<Node> n3 = new ArrayList<Node>(); 
		n3.add(node2);
		n3.add(node4);
		node3.neighbors = n3;
		
		List<Node> n4 = new ArrayList<Node>(); 
		n4.add(node1);
		n4.add(node3);
		node4.neighbors = n4;
		
		Solution sl = new Solution();
		Node result = sl.cloneGraph(node1);
		System.out.println(result);
	}
}
