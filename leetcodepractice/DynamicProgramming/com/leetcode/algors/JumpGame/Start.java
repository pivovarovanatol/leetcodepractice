package com.leetcode.algors.JumpGame;
// 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\leetcodepractice\\leetcodepractice\\DynamicProgramming\\com\\leetcode\\algors\\JumpGame\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // number of cases
       String[] arr = input.next().split(",");
		
		
		int[] nums = new int[arr.length];
		
		for (int i=0;i<arr.length;i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		
		Solution sl = new Solution();
		System.out.println(sl.canJump(nums));
		
	}
}

