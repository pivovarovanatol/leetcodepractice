package com.leetcode.algors.RectangleArea;
//https://leetcode.com/problems/rectangle-area/

import java.io.IOException;
import java.util.List;

public class Start {

    
    public static void main(String[] args) throws IOException {
            
    	//int[] arr = {1,2,4,8,16,32,64,128};
        int ret = new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.print(ret);
    }

}
