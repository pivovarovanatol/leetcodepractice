package com.leetcode.algors.ReconstructItinerary;
// https://leetcode.com/problems/reconstruct-itinerary/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
	   String path = "";
	   
	   // from discussions: Eulerian path with Hierholzer's algorithm. 5ms (<80%)
		    public List<String> findItinerary3(List<List<String>> tickets) {
		        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		        for (List<String> pair : tickets) {
		            if (!map.containsKey(pair.get(0))) map.put(pair.get(0), new PriorityQueue<>());
		            if (!map.containsKey(pair.get(1))) map.put(pair.get(1), new PriorityQueue<>());
		            map.get(pair.get(0)).offer(pair.get(1));
		        }
		        LinkedList<String> res = new LinkedList<>();
		        dfs("JFK", map, res);
		        return res;
		    }
		    
		    private void dfs(String start, HashMap<String, PriorityQueue<String>> map, LinkedList<String> res) {
		        PriorityQueue<String> queue = map.get(start);
		        while (!queue.isEmpty()) {
		            dfs(queue.poll(), map, res);
		        }
		        res.addFirst(start);
		    }
	   
	   // from discussions using PrioQueue and Stack: 9ms (<20%)
	    public List<String> findItinerary(List<List<String>> tickets) {
	    	String[][] ticks = new String[tickets.size()][2];
	    	int i=0;
	    	for (List<String> l : tickets) {
	    		ticks[i][0]=l.get(0);
	    		ticks[i][1]=l.get(1);
	    		i++;
	    	}
	        return findItineraryHelper(ticks);
	    }
	   
	   public List<String> findItineraryHelper(String[][] tickets) {
		    HashMap<String, PriorityQueue<String>> targets = new HashMap<>();
		    for (String[] ticket : tickets)
		        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
		    List<String> route = new LinkedList<>();
		    Stack<String> stack = new Stack<>();
		    stack.push("JFK");
		    while (!stack.empty()) {
		        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
		            stack.push(targets.get(stack.peek()).poll());
		        route.add(0, stack.pop());
		    }
		    return route;
		}
	   
	   
	   
	   
	   
	    public List<String> findItinerary2(List<List<String>> tickets) {
	        if (tickets==null || tickets.size()==0) return null;
	        HashMap<List<String>, Boolean> used = new HashMap<>();
	        HashMap<String, ArrayList<List<String>>> dest = new HashMap<>();
	        
	        for (List<String> l : tickets){
	            String from = l.get(0);
	            //String to = l.get(1);
	            ArrayList<List<String>> tos = dest.getOrDefault(from, new ArrayList<>());
	            tos.add(l);
	            dest.put(from, tos);
	        }
	        String currPath = "JFK";
	        dfs("JFK", dest, used, tickets.size(), currPath);
	        return pathToList(path);
	    }
	    

	    void dfs(String from,   HashMap<String, ArrayList<List<String>>>dest, HashMap<List<String>, Boolean> used, int count, String currPath){
	        // got to the end -> construct the path and save it
	        if (count==0){
	            if (path.equals("") || currPath.compareTo(path)<0) path=currPath;
	            return;
	        }
	        
	        for (List<String> to : dest.getOrDefault(from, new ArrayList<List<String>>())){
	            
	            if (!used.getOrDefault(to, false)){
	                used.put(to,true);
	                String prevPath = currPath; 
	                currPath +="|"+to.get(1);
	                dfs(to.get(1), dest, used, count-1, currPath);
	                used.put(to,false);
	                currPath = prevPath;
	            }
	        }
	    }
	    
	   List<String> pathToList(String path){
		   List<String> list = new ArrayList<String>();
		   String[] strs = path.split("\\|");
		   for (String s : strs) {
			   list.add(s);
		   }
		   return list;
	   }
	    
	}