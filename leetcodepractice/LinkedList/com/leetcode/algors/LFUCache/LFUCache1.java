package com.leetcode.algors.LFUCache;

import java.util.HashMap;
import java.util.Map;

class LFUCache1 {
    int size=0;
    int capacity;
    int smallest=1;//indicate the position for evit
    Map<Integer,Node>map=new HashMap<>();//[key,Node]
    Map<Integer,DLinkedList>listmap=new HashMap<>();
    public LFUCache1(int capacity) {
        DLinkedList l=new DLinkedList();
        listmap.put(1,l);//those with frequency 1
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node=map.get(key);
        int val=node.val;
        DLinkedList l1=listmap.get(node.fre);
        l1.remove(node);
        if(node.fre==smallest&&l1.size==0){
            smallest=node.fre+1;
        }
        node.fre++;
        if(!listmap.containsKey(node.fre)){
            DLinkedList l=new DLinkedList();
            listmap.put(node.fre,l);
        }
        listmap.get(node.fre).addLast(node);
        return val;
    }
    
    public void put(int key, int val) {
        if(!map.containsKey(key)){
            size++;
            Node node=new Node(key,val);
            map.put(key,node);
            listmap.get(1).addLast(node);
            if(size>this.capacity){//evit
                DLinkedList l=listmap.get(smallest);
                l.removeFirst();
                size--;
            }
            smallest=1;
        }else{
            Node node=map.get(key);
            DLinkedList l1=listmap.get(node.fre);
            l1.remove(node);
            if(node.fre==smallest&&l1.size==0){
                smallest=node.fre+1;
            }
            node.val=val;
            node.fre++;
            if(!listmap.containsKey(node.fre)){
                DLinkedList l=new DLinkedList();
                listmap.put(node.fre,l);
            }
            listmap.get(node.fre).addLast(node);
        }
    }
    
    
    class DLinkedList{
        Node head;
        Node tail;
        int size;
        public DLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.pre=head;
            this.size=0;
        }
        
        public void addLast(Node node){
            size++;
            Node lastnode=tail.pre;
            lastnode.next=node;
            node.pre=lastnode;
            node.next=tail;
            tail.pre=node;
        }
        
        public void removeFirst(){
            this.size--;
            Node node=head.next;
            node.next.pre=head;
            head.next=node.next;
            node.next=null;
            node.pre=null;
            map.remove(node.key);
        }
        
        public void remove(Node node){
            this.size--;
            Node P=node.pre;
            Node N=node.next;
            P.next=node.next;
            node.next.pre=P;
        }
    }
    class Node{
        int key;
        int val;
        int fre;
        Node next;Node pre;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.fre=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */