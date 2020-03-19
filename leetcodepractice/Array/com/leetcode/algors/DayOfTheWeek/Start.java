package com.leetcode.algors.DayOfTheWeek;
//https://leetcode.com/problems/day-of-the-week/

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2020, month = 03, day = 18;
		
		Solution sl = new Solution();
		String result = sl.dayOfTheWeek(day, month, year);

		System.out.println(result);
		
		
		LocalDate localDate = LocalDate.of(year, month, day); 
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		System.out.println(dayOfWeek.name());
	}
    
}

