package com.leetcode.algors.WordLadder;
// https://leetcode.com/problems/word-ladder/

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
	// solved with BFS, but too slow. 978ms(<5%) 52MB(<5%) 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a graph of Strings. Strings are connected when they have one letter difference.
        // then find the shortest path from beginWord to endWord using BFS
        // Create a graph as Adjacency List
    	wordList.add(beginWord);
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String,Boolean> connected = new HashMap<>();
        for (String word1 : wordList){
            ArrayList<String> list = new ArrayList<>();
            for (String word2 : wordList){
                if (word1 != word2 && areWordsLinked(word1,word2)){
                    list.add(word2);
                }
            }
            graph.put(word1, list);
        }
        // Look for shortest path
        int distance = bfs(graph, beginWord, endWord);
        return distance;
    }
    
    
    int dfs(HashMap<String, List<String>> graph, String beginWord, String endWord) {
    	if (beginWord.equals(endWord)) {
    		return 0;
    	}
    	List<String> children = graph.get(beginWord);
    	
    	
    	
    	return 0;
    }
    

    int bfs(HashMap<String, List<String>> graph, String beginWord, String endWord){
        Set<String> visited = new HashSet<>();
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);
        int count = 1;
        List<String> queue2 = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        while (!queue.isEmpty()){
            // get first in the queue and check if this is the search word
            String node = queue.get(0);
            queue.remove(0);
            
            // if the word we're looking for -> return current count
            if (node.equals(endWord)){
                return count;
            } else {
                // otherwirse -> add not visited children to queue and increase the count
                List<String> children = graph.get(node);
                if (children == null){
                    continue;
                }
                for (String child : children){
                    if (!visited.contains(child)){
                        visited.add(child);
                        queue2.add(child);
                    }    
                }
            }
            
            if (queue.isEmpty() && !queue2.isEmpty()) {
                count++;
                queue = queue2;
                queue2 = new ArrayList<>();
            }
            
        }
        
        return 0;        
    }
    
    
    boolean areWordsLinked(String word1, String word2){
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int count=0;

        for (int i=0;i<word1.length();i++) {
        	if (arr1[i]!=arr2[i]) {
        		count++;
        		if (count > 1) {
        			return false;
        		};
        	};
        }
        
		if (count > 1) {
			return false;
		} else {
			return true;
		}
    
    }
}
