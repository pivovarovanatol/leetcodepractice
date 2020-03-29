package com.leetcode.contests.weekly182.problem3;


class UndergroundSystem {
    // String = Stations1|Stations2, Integer[0] = sum of times, Integer[1] = count trips
    public HashMap<String, Integer[]> routes;
    public HashMap<Integer, Customer> customers;
    
    public UndergroundSystem() {
        customers = new HashMap<>();
        routes = new HashMap<>(); 
    }
    
    public void checkIn(int id, String stationName, int t) {
        Customer customer;
        if (customers.containsKey(id)){
            customer = customers.get(id);
        } else {
            customer = new Customer();
        }
        customer.id = id;
        customer.station1 = stationName;
        customer.startTime = t;    
        customers.put(id, customer);        
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer customer;
        if (customers.containsKey(id)){
            customer = customers.get(id);
        } else {
            customer = new Customer();
        }
        String route = customer.station1 + "|" + stationName;
        int time = t - customer.startTime;  
            
        if (routes.containsKey(route)){
            Integer[] arr = routes.get(route);
            arr[0] += time;
            arr[1] ++;
            //System.out.println("Updating route: " + route + " with " + arr[0] + " | " + arr[1]);
            routes.put(route, arr);
        } else {
            Integer[] arr = new Integer[2];
            arr[0] = time;
            arr[1] = 1;
            //System.out.println("Creating route: " + route + " with " + arr[0] + " | " + arr[1]);
            routes.put(route, arr);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "|" + endStation;
        //System.out.println("Getting route: "+route);
        if (routes.containsKey(route)){
            
            Integer[] arr = routes.get(route);
            //System.out.println("Route found: " + arr[0] + " | " + arr[1]);
            return (double) arr[0] / arr[1];
        } else {
            return -1;
        }            
    }
    
class Customer {
    public int id;
    public boolean inRoute;
    public String station1;
    public int startTime;
}    
    
    
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */