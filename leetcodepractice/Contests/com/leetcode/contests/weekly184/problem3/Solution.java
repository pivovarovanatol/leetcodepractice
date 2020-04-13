package com.leetcode.contests.weekly184.problem3;
// https://leetcode.com/problems/html-entity-parser/

class Solution {
    public String entityParser(String text) {
        String result = text.replace("&quot;", "\"").replace("&apos;", "\'").replace("&amp;", "&").replace("&gt;", ">").replace("&lt;", "<").replace("&frasl;", "/");
        
        return result;
    }
}