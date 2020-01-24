package com.leetcode.algors.NextGreaterElement3;
// https://leetcode.com/problems/next-greater-element-iii/

class Solution {
	
	// solved with char array manipulation. 0ms(<100%) 39MB(<10%)
    public int nextGreaterElement(int n) {
        // 579991 - > 597991 -> 591799
        // 234543321
        // idea: go from the end of the string and find the extremum (curr element < rolling Max). Counting digits on the way there.
        // once found -> replace with the next closest digits.
        // complete string by appending digits from smallest to largest.
        char[] nums = Integer.toString(n).toCharArray();
        int len = nums.length;

        int[] digits = new int[10];
        int curMax = -1;
        int swapPos=-1;
        char swapValue='a';
        
        // searching for an extremum
        for (int i=len-1;i>=0;i--){
            digits[nums[i]-'0']++;
            if (nums[i]<curMax){
                // found the extremum
                swapPos = i;
                swapValue = nums[i];
                break;
            }
            if (nums[i]>curMax){
                curMax=nums[i];
            }
        }
        
        if (swapPos==-1){
            return swapPos;
        }        
        int pointer = swapValue - '0'+1;
        
        // System.out.println("Swap pos is: " + swapPos + " SwapValue is: " + swapValue);
        
        // setting value to the next biggest digit
        while (pointer <=9){
            if (digits[pointer]>0){
                int tmp = '0' + pointer;
                nums[swapPos]= (char) tmp;
                digits[pointer]--;
                break;
            }
            pointer++;
        }
        // completing the string
        for (int i=swapPos+1;i<len;i++){
            int ind = 0;
            while(ind < 10){
                if (digits[ind]>0){
                    int tmp = '0' + ind;
                    nums[i]= (char) tmp;
                    digits[ind]--;
                    break;
                }
                ind++;
            }
        }
        
        long res = Long.parseLong(String.valueOf(nums));
        res = res > Integer.MAX_VALUE ? -1 : res;
        int ret = (int) res;
        return ret;
    }
}


