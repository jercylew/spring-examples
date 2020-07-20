package com.javatpoint;  

public class User {  
	private int m_nId;
	private String m_strName, m_strEmail;
	
	public User() {
		
	}
	
	public User(int nId, String strName, String strEmail) {  
		super();
		
		this.m_nId = nId;  
		this.m_strName = strName;  
		this.m_strEmail = strEmail;  
	}

	public String toString(){  
		return "Id:" + m_nId + " Name:" + m_strName + " Email Id:" + m_strEmail;  
	}  
}