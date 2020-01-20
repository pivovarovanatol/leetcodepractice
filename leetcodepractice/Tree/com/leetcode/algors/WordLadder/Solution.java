package com.leetcode.algors.WordLadder;
// https://leetcode.com/problems/word-ladder/

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
	
	// From discussions: 13ms(<97%) 46.9MB(<7%)
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);
        Set<String> visited = new HashSet<>();

        return helper(dict, set1, set2, visited, 1);
    }

    private int helper(Set<String> dict, Set<String> set1, Set<String> set2, Set<String> visited, int level) {
        if (set1.isEmpty()) return 0;

        if (set1.size() > set2.size()) return helper(dict, set2, set1, visited, level);

        // remove words from both ends
        visited.addAll(set1);
        visited.addAll(set2);

        // the set for next level
        Set<String> set = new HashSet<>();

        // for each string in the current level
        for (String str : set1) {
            for (int i = 0; i < str.length(); ++i) {
                // change letter at every position
                char[] chars = str.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);

                    // found the word in other end(set)
                    if (set2.contains(word)) {
                        return level + 1;
                    }

                    // if not, add to the next level
                    if (!visited.contains(word) && dict.contains(word)) {
                        System.out.println("Valid jump word: " + word);
                        set.add(word);
                        visited.add(word);
                    }
                }
            }
        }

        return helper(dict, set2, set, visited, level + 1);
    }
	
	
	// solved with BFS, but too slow. 978ms(<5%) 52MB(<5%) 
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // Create a graph of Strings. Strings are connected when they have one letter difference.
        // then find the shortest path from beginWord to endWord using BFS
        // Create a graph as Adjacency List
    	boolean containsBeginWord = false;
    	for (String str : wordList) {
    		if (str.equals(beginWord))  {
    			containsBeginWord = true;
    			break;
    		}
    	}
    	if (!containsBeginWord) wordList.add(beginWord);
    	
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
        Set<String> visited = new HashSet<>();
        
        //int dis = bfs(graph, beginWord, endWord);
        //System.out.println(dis);
        
        int distance = dfs(graph, beginWord, endWord, visited);
        return distance == Integer.MAX_VALUE ? -1 : distance+1;
    }
    
    
    int dfs(HashMap<String, List<String>> graph, String beginWord, String endWord, Set<String> visited) {
    	if (beginWord.equals(endWord)) {
    		return 0;
    	}
    	//visited.add(beginWord);
    	List<String> children = graph.get(beginWord);
    	if (children==null) {
    		return Integer.MAX_VALUE;
    	}
    	
    	int min = Integer.MAX_VALUE;
    	
    	for (String child : children) {
    		if (!visited.contains(child)) {
    			visited.add(child);
        		int dist = dfs(graph, child, endWord, visited);
        		//visited.remove(child);
        		if (dist != Integer.MAX_VALUE) {
        			if (dist==0) {
        				return 1;
        			} else {
        				min = 1 + Math.min(min, dist);
        			}
        		}
    		}
    	}
    	
    	return min;
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
