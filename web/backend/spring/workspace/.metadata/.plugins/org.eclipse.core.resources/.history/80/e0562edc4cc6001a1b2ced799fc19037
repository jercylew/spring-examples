package com.javatpoint;

public class PrintableFactory {  
	public static Printable getPrintable(String type) {  
		Printable obj = null;
		
		if (type.equalsIgnoreCase("A")) {
			obj = new A();
		}
		else if (type.equalsIgnoreCase("B")) {
			obj = new B();
		}
		else {
			System.out.println("Error, invalid type: " + type);
		}
		
		return obj;  
	}  
}
