package com.test1;

public class ThreadTest1 {
	
	private static class MyThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=1; i<=5; i++) {
				System.out.println(Thread.currentThread().getName() + " is inside the loop for iteration: " + i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " was interrupted");
				}
			}
			System.out.println(Thread.currentThread().getName() + " is finished.");
		}		
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread m = new MyThread();
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		t1.setName("MyThread1");
		t2.setName("MyThread2");
		t1.start();
		t2.start();
		int i = 0;
		while(t1.isAlive() || t2.isAlive()) {
			System.out.println(Thread.currentThread().getName() + " is waiting.");
			t1.join(1000);
			t2.join(1000);
			i++;
			System.out.println("Value of i is: " + i);
			if(i == 2) {
				System.out.println(Thread.currentThread().getName() + " is tired of waiting.");
				t1.interrupt();
				t2.interrupt();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " is finished.");
	}
}
