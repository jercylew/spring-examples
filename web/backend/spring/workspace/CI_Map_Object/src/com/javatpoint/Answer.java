package com.javatpoint;  

import java.util.Date;  

public class Answer {  
	private int m_nId;  
	private String m_strAnswer;  
	private Date m_dtPostedDate;
	
	public Answer() {
		
	}
	
	public Answer(int id, String answer, Date postedDate) {  
		super();
		
		this.m_nId = id;  
		this.m_strAnswer = answer;  
		this.m_dtPostedDate = postedDate;  
	}  

	public String toString(){  
		return "Id:" + m_nId+" Answer:" + m_strAnswer + " Posted Date:" + m_dtPostedDate;  
	}  
}