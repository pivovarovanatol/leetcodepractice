package com.leetcode.algors.RotatedDigits;
// https://leetcode.com/problems/rotated-digits/


class Solution {

	// from discussions -> 2ms (<94%) 33MB(<41%)
    public int rotatedDigits(int N) {
        //need contains one of 2,5,6,9, can't container 3,4,7         
        //0,1,8 will be 0,  2,5,6,9 will be 1,  3,4,7:2
        int[] validTable= {0,0,1,-1,-1,1,1,-1,0,1};
        int res = 0;
        for(int i=2; i<=N; i++) {
            if(isGoodNumber(validTable,i)) res++;            
        }
        return res;
    }
    
    private boolean isGoodNumber(int[] validTable,int num) {
        //in order to be a good number, num mustn't contain any digits of 3,4,7, 
        //and must contain one of 2,5,6,9
        //0,1,8 has no effect on the result;
        boolean isDifferent = false;
        while(num>0){
            int digit = num%10;
            if(validTable[digit]==-1) return false;
            else if (validTable[digit]==1) isDifferent=true;
            num/=10;
        }
        return isDifferent;
    }
	
	
	// solved without converting to String -> 3ms (<77%) 33MB(<41%)
    public int rotatedDigits1(int N) {
    int num = 0;
    int count = 0;
    int res = 0;
    for(int i=0;i<=N;i++){
        num  = i;
        count =0 ;
        while(num > 0){
            int digit = num % 10;
            if(digit == 3 || digit == 7 || digit == 4){
                count = 0;
                break;
            }else if(digit == 2 || digit == 5 || digit == 6 || digit == 9){
                count++;
            }else{
                
            }
            num = num/10;
        }
        if(count > 0){
            res++;
        }
    
    }
    
    return res; 
}

    
// with converting to String -> CharArray -> 8ms (<40%) 36MB(<10%)    
public int rotatedDigits2(int N) {
    int count=0;
    for (int i=2;i<=N;i++){
        boolean isGood = isGood(i);
        //System.out.println("Number " + i + " is good? " + isGood);
        if (isGood){
            count ++;
        }
    }
    
    return count;
}

private boolean isGood(int x){

    if (x == 1  || x == 3 || x == 4 || x == 7 || x == 8 || x == 0) {
        return false;
    }

    String s = "" + x;
    char[] arr = s.toCharArray();
    int n = arr.length;
    boolean haveRot = false;
    if (arr[0] == '3'  || arr[0] == '4'  || arr[0] == '7') {
        return false;
    } 
    
    for (int i=0;i<n;i++){
        if (arr[i] == '3'  || arr[i] == '4'  || arr[i] == '7') {
            return false;
        } 
        if (arr[i] == '2'  || arr[i] == '5' || arr[i] == '6' || arr[i] == '9') {
            haveRot = true;
        } 
    }
            
    return haveRot;
}



public int rotatedDigits3(int N) {
    int count=0;
    for (int i=2;i<=N;i++){
        String str = "" + i;
        if (str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")){
            if (!str.contains("3") || !str.contains("4") || !str.contains("7")){
                //System.out.println("Number " + i + " is good? " + isGood);
                count ++;
            }
        }
    }
    
    return count;
}


}

