package com.leetcode.algors.TrappingRainWatter;
// https://leetcode.com/problems/trapping-rain-water/

import java.util.Stack;

class Solution {
	
	// same from disc - using 2 pointers and DP
	/*
	 * The element lb[i] will store the left bound for the trapped water at position A[i]
	 * The element rb[i] will store the right bound for the trapped water at position A[i]
	 * The trapped water at position A[i] is given by the difference between the smaller bound for position A[i] (Math.min(lb[i], rb[i])), and the height at position A[i] (0 if this difference is negative).
	 */
	public static int trap(int[] A) {
		if(A==null || A.length<=1) return 0;
		int lb[] = new int[A.length]; int rb[] = new int[A.length];
		int maxFromLeft = 0; int maxFromRight = 0; int trappedWater = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i]>maxFromLeft) maxFromLeft = A[i];
			if(A[A.length-1-i]>maxFromRight) maxFromRight = A[A.length-1-i];
			lb[i] = maxFromLeft; rb[A.length-1-i] = maxFromRight;
		}
		for(int i=1;i<A.length-1;i++) {
			int leftBoundary = lb[i];
			int rightBoundary = rb[i];
			int currHeight=A[i];
			int currWater = Math.min(lb[i], rb[i])-A[i];
			trappedWater = (Math.min(lb[i], rb[i])-A[i]>0) ? trappedWater + Math.min(lb[i], rb[i])-A[i] : trappedWater;
		}
		return trappedWater;
	}
	
	// from discussions using two pointers: 1ms (<92%)
	public static int trap2(int a[]) {
		if (a == null || a.length <= 0)
			return 0;
		int n = a.length;
		int low = 0, high = n - 1, secondMaxHeight = -1, area = 0;//
		while (low <= high) {
			if (a[low] < a[high]) {
				if (a[low] > secondMaxHeight)
					secondMaxHeight = a[low];
				area += secondMaxHeight - a[low];
				low++;

			} else {
				if (a[high] > secondMaxHeight)
					secondMaxHeight = a[high];
				area += secondMaxHeight - a[high];
				high--;
			}
		}

		return area;
	}
	
	// solved with stack. 3ms (<20%)
    public int trap1(int[] height) {
        int sum = 0;
        Stack<int[]> st = new Stack<>();
        if (height==null || height.length == 0) return 0;
        
        st.push(new int[] {0, height[0]});
        //System.out.println("Current min height=" + st.peek()[1]);
        int[] bottom = new int[2];
        
        for (int i=1;i<height.length;i++){
        	int newHeight = height[i];
        	int newPos = i;
            if (st.size()>0) {
                if (height[i]<=st.peek()[1]){
                    st.push(new int[] {i, height[i]});
                    //System.out.println("Current min height=" + st.peek()[1]);
                } else if (height[i] > st.peek()[1]){
                    //System.out.println("Bottom =" + bottom[1]);
                    while (st.size()>0 && st.peek()[1] < newHeight){ // && leftMax>0
                    	bottom = st.pop();
                    	while (st.size()>0 && st.peek()[1] == bottom[1]) {// && leftMax>0
                    		bottom = st.pop();
                    	}
                    	if (st.size()>0 && st.peek()[1]>bottom[1]) {
                            int h = Math.min(newHeight, st.peek()[1])-bottom[1];
                            sum += (newPos-st.peek()[0]-1)*h;
                    	}
                    }
                    st.push(new int[] {i, height[i]});
                }
            } else {
                st.push(new int[] {i, height[i]});
                //System.out.println("Current min height=" + st.peek()[1]);
            }
        }
        return sum;
    }
}

