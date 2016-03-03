package com.test1;

import java.util.Random;

class Drop {
	
	private String message;
	private boolean isEmpty = true;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public synchronized void put(String message) {		
		if(!isEmpty) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		System.out.println(Thread.currentThread().getName() + " has produced");
		isEmpty = false;
		this.notifyAll();
		this.message = message;
	}
	
	public synchronized String take() {
		if(isEmpty) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isEmpty = true;
		this.notifyAll();
		System.out.println(Thread.currentThread().getName() + " has consumed");
		return this.message;
	}
}

class Producer implements Runnable {
	
	private Drop drop;
	
	public Producer (Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		Random random = new Random();
		String [] messages = {"message1", "message2" ,"message3", "message4"};
		for(int i=0; i< messages.length; i++) {			
			this.drop.put(messages[i]);
			System.out.println("Message added: " + messages[i]);
			try {
				System.out.println(Thread.currentThread().getName() + " is sleeping");
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.drop.put("Done");
	}
	
}

class Consumer implements Runnable {

	private Drop drop;
	
	public Consumer (Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		String message;
		while(!(message = drop.take()).equals("Done")){
			System.out.println("Message received: " + message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Drop drop = new Drop();
		Thread t1 = new Thread(new Producer(drop));
		Thread t2 = new Thread(new Consumer(drop));
		t1.setName("Producer");
		t2.setName("Consumer");
		t1.start();
		t2.start();
	}
}
