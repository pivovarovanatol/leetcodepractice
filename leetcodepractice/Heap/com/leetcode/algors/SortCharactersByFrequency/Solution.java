package com.leetcode.algors.SortCharactersByFrequency;
// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;

class Solution {
    
	
	// from discussions with bucket sort -> 13ms(<89%) 37.6MB(<100%)
    public String frequencySort(String s) {
        HashMap<Character, Integer> ct = new HashMap<>();
        for (char c : s.toCharArray()) {
            ct.put(c, ct.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] bucket = new LinkedList[s.length()+1];
        
        for (char c : ct.keySet()) {
            int i = ct.get(c);
            if (bucket[i] == null) bucket[i] = new LinkedList<>();
            bucket[i].add(c); 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = bucket.length-1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }    
                }
            }
        }
        
        return sb.toString();
    }

	
    // from discussions -> 16ms(<80%) 38.1MB(<96%)
	public static String frequencySort1(String s) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}

		Queue<String> pq = new PriorityQueue<String>((a, b) -> countMap.get(b) - countMap.get(a));

		//System.out.print(countMap.keySet());

		for (String ss : countMap.keySet()) {
			pq.offer(ss);
		}

		StringBuilder ret = new StringBuilder();

        while(!pq.isEmpty()) {
			String outputChar = pq.poll();
			if (outputChar != null) {
				int count = countMap.get(outputChar);
				for (int j = 0; j < count; j++) {
					ret.append(outputChar);
				}
			}
		}

		return ret.toString();
	}

	
	// Solved with HashMap and PriorityQueue with custom comparator. 18ms(<70%) 37.7MB(<100%)
    public String frequencySort2(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        if (n <= 0){
            return s;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Go over the string and extract characters together with frequencies in the HashSet
        for (int i=0;i<n;i++){
            char key = arr[i];
            if (map.containsKey(key)){
                int tmp = map.get(key);
                map.put(key, tmp+1);
            } else {
                map.put(key, 1);
            }
        }
        
        // Form a Heap (PriorityQueue) to have it sorted
        PriorityQueue<CharFreq> heap = new PriorityQueue<>(new Comparator<CharFreq>(){
            public int compare(CharFreq o1, CharFreq o2){
                return o2.frequency - o1.frequency;
            }
        });
        
        map.forEach((k,v) -> heap.offer(new CharFreq(k,v)));
        
        StringBuilder sb = new StringBuilder();
        
        
        // Iterate over a heap and append to the StringBuilder as many characters as frequency
        while (!heap.isEmpty()){
            CharFreq tmp = heap.poll();
            if (tmp == null){
                break;
            }
            int count = tmp.frequency;
            while (count>0){
                sb.append(tmp.character);
                count--;
            }
            
        }
        
        return sb.toString();
    }
    
    
}



class CharFreq {
    char character;
    int frequency;
    
    CharFreq(char ch, int freq){
        this.character = ch;
        this.frequency = freq;
    }
    
    public void addFreq(int increment){
        this.frequency += increment;
    }
    
    public int getFreq(){
        return this.frequency;
    }
    
}

