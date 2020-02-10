package com.leetcode.algors.BasicCalculatorII;

import java.util.Stack;

class Solution {
	// solved with traversal and shifting by *10 - 7ms (<94%) 
    public int calculate(String s) {
        int result=0;
        char[] arr = s.toCharArray();
        int n= arr.length;
        int index = 0;
        char op = '+';
        int num=0;
        StringBuilder sb = new StringBuilder();
        
        for (char ch : arr){
            if (ch==' ') {
                index++;
                continue;
            } else if (ch=='+'){
                num = parseStr(sb.toString());
                result = addSubtract(result, num, op);
                op = '+';
                sb.setLength(0);
            } else if (ch=='-'){
                num = parseStr(sb.toString());
                result = addSubtract(result, num, op);
                op = '-';
                sb.setLength(0);
            } else {
                sb.append(ch);
            } 
        }
        num = parseStr(sb.toString());
        result = addSubtract(result, num, op);
        return result;
    }
    
    int parseStr(String str){
        // here we have either number or multiplication and division commands. 
        //StringBuilder sb = new StringBuilder();
        int tmp = 0;
        int result = 1;
        char[] arr = str.toCharArray();
        char op = '*';
        //System.out.println("Executing parse with " + str);
        for (char ch : arr){
            if (ch == '*' || ch=='/'){
                result = op == '*' ? result * tmp : result / tmp;
                op = ch;
                tmp=0;
                //sb.setLength(0);
            } else if (ch != ' ') {
                tmp*=10;
                tmp += ch-'0';
                //sb.append(ch);
            }
        }
        result = op == '*' ? result * tmp : result / tmp;
        return result;
    }
	
	
	// from discussions: solved using Stack. 8ms (<90%) 
	public void pushStack(Stack<Integer> operandStack, Integer operand, int sign, char operator) {
        Integer currOperand = sign * operand;
        if (operator == '*' || operator == '/') {
            Integer prevOperand = operandStack.pop();

            if (operator == '*') {
                currOperand = prevOperand * currOperand;
            } else {
                if (operator == '/') {
                    currOperand = prevOperand / currOperand;
                }
            }
        }        
        operandStack.push(currOperand);
    }

    public int calculate1(String s) {        
        Integer operand = null;
        char operator = ' ';
        Stack<Integer> operandStack = new Stack<>();
        int sign = 1;
        int len = s.length();
        // Loop through entire expression
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            // Look for Operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (operand != null) {
                    // if there is an existing processed operand
                    pushStack(operandStack, operand, sign, operator);
                    operand = null;
                }
                // Set current operator for next operand
                operator = ch;
                // Set sign to negative or positive based on operator
                sign = ch == '-' ? -1 : 1;
            } else {
                if (ch != ' ') {
                    // Build operand by merging multiple digits
                    operand = ((operand == null ? 0 : operand) * 10) + ((int) (ch - '0'));
                }
            }
        }

        if (operand != null) {
            // For Last Operand, process it and push result to stack
            pushStack(operandStack, operand, sign, operator);
            operand = null;
        }
        Integer result = 0;
        while (!operandStack.isEmpty()) {  
            // pull all entry from stack and add all 
            result += operandStack.pop();
        }
       
        return result;
    }
	
	
	// solved with SB and one-two traversal. 11ms(<75%) 43MB(<5%)
    public int calculate2(String s) {
        int result=0;
        char[] arr = s.toCharArray();
        int n= arr.length;
        int index = 0;
        char op = '+';
        int num=0;
        StringBuilder sb = new StringBuilder();
        
        for (char ch : arr){
            if (ch==' ') {
                index++;
                continue;
            } else if (ch=='+'){
                num = parseStr(sb.toString());
                result = addSubtract(result, num, op);
                op = '+';
                sb.setLength(0);
            } else if (ch=='-'){
                num = parseStr(sb.toString());
                result = addSubtract(result, num, op);
                op = '-';
                sb.setLength(0);
            } else {
                sb.append(ch);
            } 
        }
        num = parseStr(sb.toString());
        result = addSubtract(result, num, op);
        return result;
    }
    
    int addSubtract(int x, int y, char op){
        if (op=='+') return x+y;
        else return x-y;
    }
    
    
    int parseStr2(String str){
        // here we have either number or multiplication and division commands. 
        StringBuilder sb = new StringBuilder();
        int result = 1;
        char[] arr = str.toCharArray();
        char op = '*';
        //System.out.println("Executing parse with " + str);
        for (char ch : arr){
            if (ch == '*' || ch=='/'){
                result = op == '*' ? result * Integer.parseInt(sb.toString()) : result / Integer.parseInt(sb.toString());
                op = ch;
                sb.setLength(0);
            } else if (ch != ' ') {
                sb.append(ch);
            }
        }
        result = op == '*' ? result * Integer.parseInt(sb.toString()) : result / Integer.parseInt(sb.toString());
        return result;
    }
    
    
}
