package com.leetcode.algors.Heaters;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;

public class SolutionTest {
	
	@Test
	public void testFindRadiusCase1() {
		// Case 1
		//System.out.println("Test Case #1");
		int[] houses= {1,2,3};
		int[] heaters = {2};
		
		Solution sl = new Solution();
		
		int result = 0;
		int target = 1;
		result = sl.findRadius(houses, heaters);
		
		Assert.assertEquals(target, result);
	}

	
	@Test
	public void testFindRadiusCase2() {
		// Case 2 [1,2,3,4],[1,4]
		//System.out.println("Test Case #2");
		int[] houses= {1,2,3,4};
		int[] heaters = {1,4};
		
		Solution sl = new Solution();
		
		int result = 0;
		int target = 1;
		result = sl.findRadius(houses, heaters);
		
		Assert.assertEquals(target, result);
	}

	@Test
	public void testFindRadiusCustomCase() {
		// System.out.println("Custom Test Case");
		int[] houses= {1,2,3,4,5,6,7,8,9};
		int[] heaters = {1,9};
		
		Solution sl = new Solution();
		
		int result = 0;
		int target = 4;
		result = sl.findRadius(houses, heaters);
		
		Assert.assertEquals(target, result);
	}
	
	@Test
    public void testFindRadiusHugeInputCase() throws IOException {
        BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\i855719\\git\\leetcodepractice\\leetcodepractice\\BinarySearch\\com\\leetcode\\algors\\Heaters\\data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String line;
        try {
        	
        		line = in.readLine();
			    int[] houses = stringToIntegerArray(line);
			    line = in.readLine();
			    int[] heaters = stringToIntegerArray(line);
			    
			    int result = new Solution().findRadius(houses, heaters);
				int target = 0;
			    //String out = String.valueOf(ret);
			    Assert.assertEquals(target, result);
			    //System.out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
	
}
