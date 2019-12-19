package com.leetcode.algors.IsSubsequence;
// https://leetcode.com/problems/valid-perfect-square/



class Solution {

	// Improved solution with two pointers and char array and one loop. 5ms(<90%) 49.6MB(<100%)
    public boolean isSubsequence(String s, String t) {
    	
    	char[] arrS = s.toCharArray();
    	char[] arrT = t.toCharArray();
        // let's go over Sting t char by char and compare with chars in s. 
        int lenT = t.length();
        int lenS = s.length();
        
        if (lenT==0 && lenS==0){
            return true;
        }        
        
        if (lenT==0){
            return false;
        }        

        if (lenS==0){
            return true;
        }        
        
        int pointerT  = 0;
        int pointerS = 0;
        int offset = 0;
        
        // find the appearance of the first char
        while (offset < lenT){
            
            if (arrT[offset] == arrS[0]){
                break;
            } 
            offset++;
        }
        // iterating further to get the full string compared 
        pointerT=offset;
        while (pointerT < lenT){
            if (arrT[pointerT] == arrS[pointerS]){
                if (pointerS == lenS-1) {
                    return true;
                } else {
                    pointerT++;
                    pointerS++;
                }

            } else {
                pointerT++;
                if (pointerT > lenT-1){
                    break;
                }
            }
        }
        
        return false;
    }
	
	
	
	// solved with two pointers and char array. 10ms (<80%) 48.8MB(<100%)
    public boolean isSubsequence2(String s, String t) {
    	
    	char[] arrS = s.toCharArray();
    	
    	char[] arrT = t.toCharArray();
        
        // let's go over Sting t char by char and compare with chars in s. 
        int lenT = t.length();
        int lenS = s.length();
        
        if (lenT==0 && lenS==0){
            return true;
        }        
        
        if (lenT==0){
            return false;
        }        

        if (lenS==0){
            return true;
        }        
        
        int pointerT  = 0;
        int pointerS = 0;
        int offset = 0;
        
        while (offset < lenT){
            
            if (arrT[offset] == arrS[0]){
                pointerT=offset;
                pointerS=0;
                while (pointerT < lenT){
                   //System.out.println("Checking symbol " + t.charAt(pointerT) + " with " + s.charAt(pointerS));

                    if (arrT[pointerT] == arrS[pointerS]){
                        //System.out.println("Found matching symbol " + s.charAt(pointerS) + " from position " + pointerT + " at " + pointerS);
                        // checked till the last symbol -> return true
                        if (pointerS == lenS-1) {
                            return true;
                        } else {
                            // increase pointers
                            pointerT++;
                            pointerS++;
                        }

                    } else {
                        pointerT++;
                        //System.out.println("Increasing pointerS to: "+ pointerS);
                        if (pointerT > lenT-1){
                            break;
                        }
                    }
                }
            } 
            offset++;
        }
     
        return false;
    }

	
	
	// solved with two pointers and String.charAt().  13ms(<69%) 48MB(<100%)
    public boolean isSubsequence1(String s, String t) {
        
        String tmp = s;
        s = t;
        t = tmp;
        
        // let's go over Sting t char by char and compare with chars in s. 
        int lenT = t.length();
        int lenS = s.length();
        
        if (lenT==0 && lenS==0){
            return true;
        }        
        
        if (lenS==0){
            return false;
        }        

        if (lenT==0){
            return true;
        }        
        
        int pointerT  = 0;
        int pointerS = 0;
        int start = -1;
        int offset = 0;
        
        while (offset < lenS){
            
            if (s.charAt(offset) == t.charAt(0)){
                pointerS=offset;
                pointerT=0;
                while (pointerS < lenS){
                   //System.out.println("Checking symbol " + t.charAt(pointerT) + " with " + s.charAt(pointerS));

                    if (s.charAt(pointerS) == t.charAt(pointerT)){
                        //System.out.println("Found matching symbol " + s.charAt(pointerS) + " from position " + pointerT + " at " + pointerS);
                        // checked till the last symbol -> return true
                        if (pointerT == lenT-1) {
                            return true;
                        } else {
                            // increase pointers
                            pointerT++;
                            pointerS++;
                        }

                    } else {
                        pointerS++;
                        //System.out.println("Increasing pointerS to: "+ pointerS);
                        if (pointerS > lenS-1){
                            break;
                        }
                    }
                }
            } 
            offset++;
        }
     
        return false;
    }


}

