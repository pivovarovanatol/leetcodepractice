package com.leetcode.algors.NaryTreePostOrderTraversal;
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//-1 represents null values
		// int[] arr1 = {5,3,7,2,4,6,8,1};
		// int[] arr1 = {1,-1,2,-1,-1,3,-1};
		// int[] arr1 = {1,-1,2,-1,-1,3,-1,-1,-1};
		
		int[] arr1 = {1,-1,3,2,4,-1,5,6,-1,-1};
		 
		Solution sl = new Solution();
		List<Node> l = new ArrayList<>();

		Node node1 = new Node(arr1[0]);
		Node node2 = new Node(arr1[2]);
		Node node3 = new Node(arr1[3]);
		Node node4 = new Node(arr1[4]);
		Node node5 = new Node(arr1[6]);
		Node node6 = new Node(arr1[7]);
		
		l.add(node2);
		l.add(node3);
		l.add(node4);
		node1.children = l;
		
		l = new ArrayList<>();
		l.add(node5);
		l.add(node6);
		
		node2.children =l;
		
		Node root = node1;
		
		//printByLevel(root);
		//System.out.println();
		List<Integer> result = sl.postorder1(root);
		for (int e : result) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		
		result = sl.postorder(root);
		for (int e : result) {
			System.out.print(e + " ");
		}
	}
}

