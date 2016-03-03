package com.test1;

class A {
	void a() throws Exception {
		throw new Exception();
	}
}

class B extends A {
	
	void b() throws Exception {
		a();
	}
}

class C extends B {
	
	void c() throws Exception {
		b();
	}
}

public class ErrorHandling {

	public static void main(String[] args) {
		C obj = new C();
		
		try {
			obj.c();			
		} catch(Exception ex) {
			Throwable t = ex.getCause();
			if(t == null) {
				System.out.println("Throwable is null");
			} else {
				System.out.println(t.getMessage());
			}
		}
	}
}
