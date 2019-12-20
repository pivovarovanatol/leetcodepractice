package com.leetcode.algors.IntegerToOct;

public class Start {

	public static void main(String[] args) {
		int n=10000;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toOctalString(n));
		
		String res = "";
		
		while (n >0) {
			String tmp = Integer.toBinaryString(n);
			if (tmp.length() > 3) {
				tmp = tmp.substring(tmp.length()-3, tmp.length());
			}
			int a = binaryToInt(tmp);
			System.out.println("Part is: " + tmp + " converted to " + a);
			res = a+res;
			n = n >> 3;
			//System.out.println(Integer.toBinaryString(n));
		}
		System.out.println(res);
	}
	
	static int binaryToInt(String s) {
		int res=0;
		char[] arr = s.toCharArray();
		
		for (int i=s.length()-1;i>=0;i--) {
			if (arr[i]=='1') {
				res = res + (int) Math.pow(2, s.length()-i-1);
			}
		}
		
		return res;
	}
}

