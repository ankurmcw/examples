package com.test1;

final class Singleton {
	
	// private static Singleton instance = new Singleton(); // create instance eagerly
	
	private static Singleton instance; // create instance lazily
	
	private Singleton() {
		if(instance != null) {
			throw new InstantiationError("Cannot create instance of " + Singleton.class.getName() + " through Reflection.");
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot create a clone of " + Singleton.class.getName());		
	}
	
	public static Singleton getInstance() {
		// Double checked locking
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
					System.out.println("Instance created");
				}				
			}			
		}
		return instance;
	}
}


public class SingletonImpl implements Runnable{
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Singleton s = new Singleton(); this is not possible as constructor of Singleton class is private
		
		SingletonImpl s = new SingletonImpl();
		
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		
		t1.start();
		t2.start();
		
		Class<Singleton> c = (Class<Singleton>) Class.forName("com.test1.Singleton");
		try {
			Singleton obj = (Singleton) c.newInstance();
		} catch(Error | InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	@Override
	public void run() {		
		Singleton s = Singleton.getInstance();
		try {
			Singleton s1 = (Singleton) s.clone();
			s1.toString();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		s.toString();
	}

}

class BillPughSingleton {		
	
	private BillPughSingleton() {};
	
	private static class SingletonHelper {
		private static BillPughSingleton instance = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHelper.instance;
	}
}

enum EnumSingleton {
	
	INSTANCE;
	
	public void singletonMethod() {
		System.out.println("Test enum singleton");
	}
}

class TestEnum {
	
	public static void main(String[] args) {
		EnumSingleton.INSTANCE.singletonMethod();
	}
}
