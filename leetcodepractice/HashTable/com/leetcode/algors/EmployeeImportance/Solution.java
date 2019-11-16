package com.leetcode.algors.EmployeeImportance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/employee-importance/


// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution {
	
	
	//From discussions - clean DFS ->  5ms (<99%) 47.5MB(<95%)
	public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idToEmployee = new HashMap<>();
		Employee root = null;
		for(Employee e : employees) {
			idToEmployee.put(e.id, e);
			if(e.id == id) {
				root = e;
			}
		}
		return getImportanceDFS(idToEmployee, root.id);
    }
	
	private int getImportanceDFS(Map<Integer, Employee> idToEmployee, int rootId) {
		int importance = idToEmployee.get(rootId).importance;
		for(int id : idToEmployee.get(rootId).subordinates) {
			importance += getImportanceDFS(idToEmployee, id);
		}
		return importance;
	}
	
	
	
	// Solved with BFS + HashMap -> 9ms 46.6MB
    public int getImportance2(List<Employee> employees, int id) {
        
    	if (employees == null) {
    		return 0;
    	}
    	
        HashMap<Integer, Employee> hm = new HashMap<>();
        
        for (Employee emp : employees){
            hm.put(emp.id, emp);
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int importance = 0;
        
        deque.addLast(id);
        
        while (!deque.isEmpty()) {
            int tmpId = deque.removeFirst();
            Employee tmpEmp = hm.get(tmpId);
            importance += tmpEmp.importance;
            
            for (int i : tmpEmp.subordinates){
                deque.addLast(i);
            }
        }
        
     return importance;
    }
    
    
}