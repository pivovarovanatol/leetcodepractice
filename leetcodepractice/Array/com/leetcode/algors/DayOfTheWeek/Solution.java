package com.leetcode.algors.DayOfTheWeek;
// https://leetcode.com/problems/day-of-the-week/


class Solution {
	// solved with math. 0ms(<100%) 36.7MB(<100%)
	public String dayOfTheWeek(int day, int month, int year) {
        int diff = 0;
        
        int diffY = (year - 1900);
        int leapYears = diffY/4;
        diffY = diffY * 365 + leapYears;
        boolean isLeapYear = year % 4 == 0;
        if (isLeapYear && month <= 2) diffY--;
        
        int diffM = 31 * (month-1);
        
        // deduct February
        if (diffM >0 && month > 2) {
            diffM -=3;
        }
        
        // minus one day for April, June, September and November
        if (month > 4) diffM--;
        if (month > 6) diffM--;
        if (month > 9) diffM--;
        if (month > 11) diffM--;
        
        diff = diffY + diffM + day;
        System.out.println(diff + " = " + diffY + " + " + diffM + " + " + day);
        
        int dow = (int) diff % 7;
        String result = "";
        //System.out.println(dow);
        switch(dow) {
            case 1: result = "Monday";
                    break;
            case 2: result = "Tuesday";
                    break;
            case 3: result = "Wednesday";
                    break;
            case 4: result = "Thursday";
                    break;
            case 5: result = "Friday";
                    break;
            case 6: result = "Saturday";
                    break;
            case 0: result = "Sunday";
                    break;
        }
        
        return result;
    }
}

