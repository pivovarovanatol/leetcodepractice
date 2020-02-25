package com.leetcode.algors.GoogleSpyTunnel;

class Solution {
	public boolean canPass(int[] coordinatesX, int[] coordinatesY, int[] radiuses, int bottom, int top) {
		// Iterate over vertices by checking if two mines overlap.
		// While iterating - keep track of the lowest and highest boundaries. 
		// If completely blocks tunnel -> return false
		// Otherwise -> return true; 
		
		int minesCount = radiuses.length;
		
		// data structure to store the mines reach. 0 - lower boundary, 1 - upper boundary
		int [][] mineReach = new int[minesCount][];
		
		for (int i=0;i<minesCount;i++) {
			mineReach[i] = new int[2];
			mineReach[i][0] = coordinatesY[i] - radiuses[i];
			mineReach[i][1] = coordinatesY[i] + radiuses[i];
		}
		
		// calculate reach for every mine
		for (int i=0;i<minesCount;i++) {
			for (int j=i;j<minesCount;j++) {
				if (i!=j) {
					double dist = (coordinatesX[i]-coordinatesX[j])*(coordinatesX[i]-coordinatesX[j]) + (coordinatesY[i]-coordinatesY[j])*(coordinatesY[i]-coordinatesY[j]);
					double distance = Math.sqrt(dist);
					
					// connected
					if (distance <= radiuses[i]+radiuses[j]) {

						System.out.println("Mines at " + i + " and " + j + " are connected with distance and radiuses: " + distance + " | " + (radiuses[i]+radiuses[j]));
						
						int lowest = Math.min(mineReach[i][0], mineReach[j][0]);
						mineReach[i][0] = lowest;
						mineReach[j][0] = lowest;
						
						int highest = Math.max(mineReach[i][1], mineReach[j][1]);
						mineReach[i][1] = highest;
						mineReach[j][1] = highest;
						
						if (lowest <= bottom && highest >= top) {
							System.out.println("Failed to pass mines at " + i + " and " + j + " with boundaries at: " + lowest + " | " + highest);
							return false;
						}
					} else {
						System.out.println("Mines at " + i + " and " + j + " are NOT connected with distance and radiuses: " + distance + " | " + (radiuses[i]+radiuses[j]));
					}
				}
			}
		}
		
		return true;
	}
}