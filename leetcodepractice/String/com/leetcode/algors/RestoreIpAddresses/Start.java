package com.leetcode.algors.RestoreIpAddresses;
//https://leetcode.com/problems/restore-ip-addresses/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
		List<String> result = sl.restoreIpAddresses("255110164");

		for (String i : result) {
			System.out.println(i);
		}
	}
}

