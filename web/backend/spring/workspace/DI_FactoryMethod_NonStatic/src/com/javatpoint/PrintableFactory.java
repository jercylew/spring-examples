package com.javatpoint;

public class PrintableFactory {  
	//non-static factory method
	public Printable getPrintable(){  
//		return new A();
		return new B();
	} 
}
