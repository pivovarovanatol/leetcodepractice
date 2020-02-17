package com.leetcode.algors.CourseSchedule;
// https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
	// from discussions: 3 ms. Same idea, but instead of recursion we do DFS with Stack. 3ms(<90%)
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int rescount = 0;
		LinkedList<Integer>[] graph = new LinkedList[numCourses];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<>();
		}
		short inDegree[] = new short[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int start = prerequisites[i][0];
			int end = prerequisites[i][1];
			graph[start].add(end);
			inDegree[end]++;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				stack.push(i);
			}
		}
		while (stack.size() > 0) {
			int a = stack.pop();
            rescount++;
			for (int i = 0; i < graph[a].size(); i++) {
				Integer node = graph[a].get(i);
				inDegree[node]--;
				if (inDegree[node] == 0) {
					stack.push(node);
				}
			}
		}
        if(rescount ==numCourses){
            return true;
        }
		
		return false;
	}
	
	
	// initial solution with HashMap - 222ms (<5%). Optimized with array of List - 165ms(<6%).
	// need to check the Topological Sort algorithm.  
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // naive idea: go over the list of pre-requisites and for each course go to it's prerequisit and recurse. 
        // if course has a prerequisite -> go deeper. If not - return true. Check for circles as dp nodes. If dp -> return false.
        boolean canFinish = true;
        List<Integer>[] prereq = new LinkedList[numCourses];
        
        // check for dependencies.
        for (int[] k : prerequisites){
            if (prereq[k[0]]!=null){
                prereq[k[0]].add(k[1]);
            } else {
                List<Integer> p = new ArrayList<>();
                p.add(k[1]);
               prereq[k[0]]=p;
            }
        }
                
        
        for (int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int prev = prerequisites[i][1];
            boolean[] visited = new boolean[numCourses];
            visited[course] = true;
            HashMap<Integer, Boolean> dp = new HashMap<Integer, Boolean>();
            canFinish = canFinish1(prev, prerequisites, dp, prereq, visited);
            if (!canFinish) return false;
        }
        
        return canFinish; 
    }
    
    boolean canFinish1(int course, int[][] prerequisites, HashMap<Integer, Boolean> dp, List<Integer>[] prereq, boolean[] visited){
        if (dp.containsKey(course)) return dp.get(course);
        if (visited[course]) return false;
        boolean canFinish = true;
        visited[course] = true;

        // no prerequisites -> return true
        if (prereq[course]==null) return true;

        List<Integer> p = prereq[course];
        for (int rootCourse : p){
            canFinish = canFinish & canFinish1(rootCourse, prerequisites, dp, prereq, visited);
            if (!canFinish) {
                //System.out.println("Unable to finish node: " + rootCourse);
                return false;
            }
            dp.put(rootCourse, true);
        }
        dp.put(course, true);
        return canFinish; 
    }
    
    
}
