package com.leetcode.algors.GreatestCommonDivisor;

class Solution {
	// for a,b > 0
	// gcd(a,a) = a,
	// gcd(a,b) = gcd(a-b,b), if a>b
	// gcd(a,b) = gcd(a,b-a), if b>a
	public int gcd(int a, int b) {
		if (b==0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	// lcm(a,b) = a*b / gcd(a,b)
	public int lcm(int a, int b) {
		
		return (a*b)/gcd(a,b);
	}
	
	
 }
