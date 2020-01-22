package com.leetcode.algors.CircularArrayLoop;
// https://leetcode.com/problems/circular-array-loop/

class Solution {
	// from discussions. Same idea, different implementation, changes array(!). 0ms (<100%) 40MB(<11%)
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            int cur = i, dir = 0, prev = i; 
            while(nums[cur] <= 1000){  
                prev = cur; 
                int t = (cur + nums[cur])%nums.length;
                if(nums[cur] < 0){
                    cur = t < 0 ? (nums.length + t) : t;
                    dir = (dir == 0 || dir == 1) ? 1 : 3;
                }else{
                    cur = t;
                    dir = (dir == 0 || dir == 2) ? 2 : 3;
                } 
                if(dir == 3) break; 
                nums[prev]  = 1001 + i; 
                if(cur == prev) break; 
            } 
            if(prev != cur && nums[cur] == (1001 + i) && dir != 3) return true;
        }
        return false;
    }
	
	// solved with two pointers. 9ms(<50%) 43MB(<11%)
    public boolean circularArrayLoop1(int[] nums) {
        // create two pointers - first to iterate over the array one by one and second is to follow the circle. 
        // If change of direction -> no circle. If jump over pointer1 (back or forward) -> no loop(?).
        int pointer1=0;
        int pointer2=0;
        int n= nums.length;
        boolean hasCycle = false;
        
        while (pointer1 < n){
            int size = 1;
            pointer2 = pointer1;
            int direction = nums[pointer1] > 0 ? 1 : -1;
            boolean[] visited = new boolean[n];
            visited[pointer1]=true;
            boolean keepLooping = true;
            
            while (keepLooping){
            	if (Math.abs(nums[pointer2]) == n) {
            		break;
            	}
                pointer2 += nums[pointer2];
                // pointer2 going beyond the array boundaries -> loopOver and keeping pointer2 within array boundaries
                if (pointer2 >= n ){
                    pointer2 = pointer2 % n;
                } else if (pointer2 < 0){
                    pointer2 = n + (pointer2 % n);
                }
                //System.out.println(direction + " " + pointer1 + " " + pointer2 + " " + loopOver);

                // already been here -> check if length > 1 -> loop -> return true;
                if (visited[pointer2]){
                	if (size>1) {
                		return true;
                	} else {
                		break;
                	}
                } 
                visited[pointer2] = true;
                size++;

                // change of direction -> no loop. Continue cycle with other pointer1.
                if ((direction > 0 && nums[pointer2] < 0) || (direction < 0 && nums[pointer2] > 0)){
                    break;
                }
                
            }
            pointer1++;
        }
        return hasCycle;
    }
}

