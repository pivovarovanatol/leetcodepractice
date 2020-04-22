package com.leetcode.algors.LeftmostColumnWithAtLeastOne;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix {
//	int[][] matrix =   {{0,0,0,0,0,0,1},
//						{0,0,0,0,0,1,1},
//						{0,0,0,0,1,1,1},
//						{0,0,0,0,0,1,1},
//						{0,0,0,1,1,1,1},
//						{0,0,0,0,1,1,1},
//						{0,0,0,0,0,0,0},
//					   };
	
//	int[][] matrix =   {
//			{0,0},
//			{1,1}
//		   };
	
	int[][] matrix =   {
						{0,0,0,1},
						{0,0,1,1},
						{0,1,1,1}
					   };
	
	public List<Integer> dimensions;
	
	public BinaryMatrix() {
		 dimensions = new ArrayList<Integer>();
		 dimensions.add(matrix.length);
		 dimensions.add(matrix[0].length);
	}
	public List<Integer> dimensions() {
		return dimensions;
	}	
	public int get(int y, int x) {
		return matrix[y][x];
	}
}
