package com.leetcode.algors.Heaters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;

public class Start {

	public static void main(String[] args) {
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
			    
			    System.out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] stringToIntegerArray(String input) {
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
