package com.leetcode.algors.GoogleMultiThreaded;

import java.util.Random;

class Solution implements Runnable{
	int number;
	
	@Override
//	public synchronized void run() {
	public void run() {
		// TODO Auto-generated method stub
		
		Thread currentThread = Thread.currentThread();
		
		Random rand = new Random(); 
		int k = rand.nextInt(10);
		System.out.println("Instance #" + number + " with k=" + k);
		String str ="asdlkmaslkdmaslkmdalskmdlaksmdlaskmdalksdkmasdnmaskjdnakdhqwiuehdnkqwnsckjasncskdjcksdcnwoinmelkqwjndriqewr;wlnmkcljkdsncjhslkbcskdmnskfiuwerj[opqwerkksdncvljsnlcjsa"; 
		
		for (int i=0;i<k;i++) {
			System.out.println("Instance #" + currentThread.getId() + " with k=" + k + " running step: " + i);
			for (int j=1;j<1000;j++) {
				Random r = new Random();
				int start = r.nextInt(j);
				str += str.substring(start+1, j+1) ;
			}
		}
		
	}
	
}