package com.leetcode.algors.ExcelSheetColumnTitle;
//https://leetcode.com/problems/sqrtx/

class Solution {
	
    public String convertToTitle(int n) {
        
    	int level1 = 26;
    	int level2 = level1 * level1;
    	int level3 = level2 * level1;
    	int level4 = level3 * level1;
    	int level5 = level4 * level1;
    	int tmp=0;

    	int count1=-1, count2=-1, count3=-1, count4=-1, count5 = -1;
    	
    	char letter5=' ';
    	char letter4=' ';
    	char letter3=' ';
    	char letter2=' ';
    	char letter1=' ';
    	
    	for (int i=0;i<=n-1;i++) {
    		count1++;
    		
    		
    		if (count1 >= 26) {
    			count1 = 0;
    			count2++;
    		}
    		if (count2 >= 26) {
    			count2 = 0;
    			count3++;
    		}
    		if (count3 >= 26) {
    			count3 = 0;
    			count4++;
    		}
    		if (count4 >= 26) {
    			count4 = 0;
    			count5++;
    		}
    		if (count5 >= 26) {
    			count5 = 0;
    		}

    		
    		letter1 = (char) (65 + (count1 % 26));
    		
    		if (i > 25) {
        		letter2 = (char) (65 + (count2 % 26));
    		} else {
    			letter2=' ';
    		}
    		
    		if (i > 701) {
        		letter3 = (char) (65 + (count3 % 26));
    		} else {
    			letter3 = ' ';
    		}
    		
    		if (i > 18277) {
        		letter4 = (char) (65 + (count4 % 26));
    		} else {
    			letter4=' ';
    		}
    		
    		if (i>475254) {
        		letter5 = (char) (65 + (count5 % 26));
    		} else {
    			letter5 = ' ';
    		}


    		//System.out.println(i + " + " + letter5 + "(" + count3 + ")" + letter4  + "(" + count3 + ")" + letter3  + "(" + count3 + ")" + letter2 + "(" + count2 + ")" + letter1 + "(" + count1 + ")");
    		
    		//System.out.println(i + " + " + letter5 + letter4  + letter3  + letter2 + letter1);
    		
    		//Thread.sleep(20);
    	}
    	
    	//System.out.println(String.valueOf(letter5) + String.valueOf(letter4) + String.valueOf(letter3) + String.valueOf(letter2) + String.valueOf(letter1));
    	StringBuilder str = new StringBuilder(); 
    	
    	str.append(letter5);
    	str.append(letter4);
    	str.append(letter3);
    	str.append(letter2);
    	str.append(letter1);

    	return str.toString().trim();
    }

	
	
    public String convertToTitle2(int n) {
     
    	int tmp=0;
    	
    	char letter1 = (char) (65 + ((n -1)% 26));
    	
    	tmp = ((n-1)/26)-1;
    	char letter2 = n > 26 ? (char) (65 + tmp % 26) : ' ';
    	
    	tmp = ((n)/(27*26));
    	char letter3 = n > 702 ? (char) (65 + (tmp % 26)) : ' ';
    	
    	tmp = ((n-1)/(27*26*26 + 26*26 + 26))-1;
    	char letter4 = n > 18252 ? (char) (65 + (tmp)) : ' ';

    	char letter5 = 0;
    	
    	StringBuilder str = new StringBuilder(); 
    	
    	str.append(letter5);
    	str.append(letter4);
    	str.append(letter3);
    	str.append(letter2);
    	str.append(letter1);

    	return str.toString().trim();    	
    	
    }
}