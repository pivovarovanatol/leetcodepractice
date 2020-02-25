package com.leetcode.algors.GoogleSpyTunnel;

public class Start {

	public static void main(String[] args) {
		// Can the spy pass the tunnel with mines?
		// Given mines coordinates and radiuses they cover and tunnel boundaries.
		// Check if spy can go thru
		
		int[] coordinatesX = {2,4,6,8,10};
		int[] coordinatesY = {0, 2, 4, 6, 8};
		int[] radiuses = {2,2,2,2,2};
		int bottom = 0;
		int top = 10;
		
		Solution sl = new Solution();
		boolean result = sl.canPass(coordinatesX, coordinatesY, radiuses, bottom, top);
		System.out.println(result);
	}
}
