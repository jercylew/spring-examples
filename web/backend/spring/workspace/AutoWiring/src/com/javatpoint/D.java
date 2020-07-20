package com.javatpoint;

/**
 * 
 * @author Administrator
 * Demo of Auto Wiring by type, it works by setter internally
 */

public class D {
	B bObject;
	
	D() {
		System.out.println("D is created");
	}
	
	public B getbObject() {
		return bObject;
	}

	public void setbObject(B bObject) {
		this.bObject = bObject;
	}
	
	void print() {
		System.out.println("hello D");
	}
	
	void display() {
		print();
		bObject.print();
	}
}
