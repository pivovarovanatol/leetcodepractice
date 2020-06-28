package com.leetcode.algors.ReconstructItinerary;
//https://leetcode.com/problems/reconstruct-itinerary/

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		String[][] s = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
		for (int i=0;i<s.length;i++) {
			List<String> l = new ArrayList<>();
			for (int j=0;j<2;j++) {
				l.add(s[i][j]);
			}
			tickets.add(l);
		}
		
		
		Solution sl = new Solution();
		List<String> actual = sl.findItinerary(tickets);
		
//		for (String p : actual) {
//			System.out.println(p);
//		}
		System.out.println(actual);
		
	}
	
}

